<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cartlist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/js/round.js'/>"> </script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/cart/list.css'/>">
<script type="text/javascript">
$(function() {
	//全选按钮实现
	 $("#selectAll").click(function(){
	  
			$(":checkbox[name=checkboxBtn]").each(function(){
					
					if($("#selectAll").attr("checked")){
							$(this).attr("checked",true)
					}else{
					
							$(this).attr("checked",false)
					}
			})
	  
	})   
	
	
	
	
	
	
	//删除列表项提示实现

		$(".deletecartitem").click(function(){
		if(confirm("您是否真要删除该条目？")){
				return true
		}
		return false
	})
	
	
		
	
	//给加减添加实现
	
		$(".jian").click(function(){
			
			var  num  = Number($("#"+$(this).attr("jianid")+"quantity").val());
			if(num==1){
				if(confirm("您是否真要删除该条目？")){
					location.href="/goods/delete/"+$(":checkbox[name=checkboxBtn]").attr("value");
				}
			
			}else{
				$("#"+$(this).attr("jianid")+"quantity").val(num-1);
				location.href="/goods/updatajian/"+$(this).attr("jianid")
			}
			
		})
		
		
		$(".jia").click(function(){
			
			var  num  = Number($("#"+$(this).attr("jianid")+"quantity").val());
				$("#"+$(this).attr("jianid")+"quantity").val(num+1);
				location.href="/goods/updatajia/"+$(this).attr("jianid")
		})
	
	
		$("#piliangdelid").click(function(){
			if(confirm("您确定删除选中的条目吗？")){
							var  ids  = new Array();
							$(":checkbox[name=checkboxBtn][checked=true]").each(function(){
								ids.push($(this).attr("id"));
							});
							
							location.href ="/goods/deletecartitems?ids="+ids;
							return  true;
							
						}else{
							return false  ;
						}
		})
		
		$(":checkbox").click(function(){
			yincangdelete();
		})
	
	//总计
	total();
	
	//批量删除的隐藏于显示
	yincangdelete();
})

function total(){
	
	 	var sum = 0;
	 	$(".subTotal").each(function(){
	 		sum+=Number($(this).text());
	 	})
	 	 $("#total").text(round(sum,2));
	}
	
function yincangdelete(){
	
		var flags = false;
		$(":checkbox[name=checkboxBtn][checked=true]").each(function(){
					flags = true
		});
		if(flags){
			$("#piliangdelid").css('display','block');
		}else{
			$("#piliangdelid").css('display','none');
		}

}


</script>
  </head>
  <body>
  <c:choose >
	
		<c:when test="${fn:length(cartItems) == 0 }">
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/images/icon_empty.png'/>"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  
	</c:when>
	<c:otherwise>
<br/>
<br/>


<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<input type="checkbox" id="selectAll" /><label for="selectAll">全选</label>
		</td>
		<td colspan="2">商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>





	<c:forEach  items="${cartItems }"  var ="cartItem">

	<tr align="center">
	
	<!-- 复选按钮 -->
	
		<td align="left">
			<input value="${cartItem.cartitemid }" id="${cartItem.cartitemid }" type="checkbox" name="checkboxBtn" />
		</td>
		
	<!-- 图书图片 -->
		<td align="left" width="70px">
			<a class="linkImage" href="<c:url value='/selectbid/${cartItem.book.bid }'/>"><img border="0" width="54" align="top" src="<c:url value='/${cartItem.book.imageB }'/>"/></a>
		</td>
		
	<!-- 图书名 -->
		<td align="left" width="400px">
		    <a href="<c:url value='/selectbid/${cartItem.book.bid }'/>"><span>${cartItem.book.bname }</span></a>
		</td>
		
	<!-- 图书价格 -->
		<td><span>&yen;<span class="currPrice" id="12345CurrPrice">${cartItem.book.currprice }</span></span></td>
		
	<!-- 调整数量 -->
		<td>
			<a class="jian" jianid="${cartItem.cartitemid }" id="${cartItem.cartitemid }jian"></a>
			
			<input class="quantity" readonly="readonly" id="${cartItem.cartitemid }quantity" type="text" value="${cartItem.quantity }"/>
			
			<a class="jia" id="${cartItem.cartitemid }jia" jianid="${cartItem.cartitemid }"></a>
		</td>
		
	<!-- 小计 -->
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="12345Subtotal">${cartItem.subTotal}</span></span>
		</td>
		
	<!-- 删除 -->
		<td>
			<a class="deletecartitem" href="<c:url value='/delete/${cartItem.cartitemid}'/>">删除</a>
		</td>
	</tr>
	
	
	</c:forEach>
	
	<tr>
		<td colspan="4" class="tdBatchDelete">
			<a  id="piliangdelid">批量删除</a>
		</td>
		<td colspan="3" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;<span id="total"></span></span>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right">
			<a href='javascript:jiesuan();' id="jiesuan" class="jiesuan"></a>
			<form id="form1" action="<c:url value='/jsps/cart/showitem.jsp'/>" method="post">
		<!-- <input type="hidden" name="cartItemIds" id="cartItemIds"/>
		<input type="hidden" name="method" value="loadCartItems"/> -->
	</form>
	<script type="text/javascript">
		function jiesuan(){
			//alert(123);
			var  idss = new Array();
			$(":checkbox[name='checkboxBtn'][checked=true]").each(function(){
				var id = $(this).attr("id");
				idss.push(id);
				
			});	
			$("#form1").attr("action","/goods/jiesuan/"+idss);
			$("#form1").submit();
			//return  true;
		}
	</script>
		</td>
	</tr>
</table>
	</c:otherwise>
	</c:choose>
  </body>
</html>
