// JavaScript Document
//登录弹出框JS
function showDiv(){
document.getElementById('popDiv').style.display='block';
document.getElementById('bg').style.display='block';
}

function closeDiv(){
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
document.getElementById('popDiv1').style.display='none';
}

function qiehuan_iphone(){
document.getElementById('popDiv').style.display='none';
document.getElementById('popDiv1').style.display='block';
}
function qiehuan_zhanghao(){
document.getElementById('popDiv1').style.display='none';
document.getElementById('popDiv').style.display='block';
}

//幻灯片JS
$(function() {
	var bannerSlider = new Slider($('#banner_tabs'), {
		time: 3000,//3s间隔时间
		delay: 400,
		event: 'hover',
		auto: true,
		mode: 'fade',
		controller: $('#bannerCtrl'),
		activeControllerCls: 'active'
	});
	$('#banner_tabs .flex-prev').click(function() {
		bannerSlider.prev()
	});
	$('#banner_tabs .flex-next').click(function() {
		bannerSlider.next()
	});
})

//滚动窗口js
$(function(){
	$(window).scroll(function(){
		var t=$(this).scrollTop()
		if(t>100){
			$(".scroll_wrap").stop().show();	
		}else{
			$(".scroll_wrap").stop().hide();	
		}	
		
	})
	
	$(".scroll_wrap .totop").click(function(){
		
		$("body,html").stop().animate({scrollTop:0},300)
	})
})

//产品列表tab切换js
function change_div(id){
	var li_list=document.getElementsByClassName("searchli");
	var div_list=document.getElementsByClassName("search_list_jg");
	for(var i=0;i<li_list.length;i++){
		// div_list[i].style.display = "none";
		li_list[i].className="searchli";
	}
	// document.getElementById("searchdiv"+id).style.display = "block";
	// document.getElementById("searchli"+id).classList.add = "search_active";
	var menuid="searchli"+id;
	var menu=$("#"+menuid+">a").text();
	// console.log(menu);
	// $.ajax({
	// 	url:"/Tradesystem/product/sublist",
	// 	data:{"menu":menu},
	// 	dataType:"json",
	// 	type:"get",
	// 	success:function(submenu){
	// 		$("#searchdiv>ul").empty();
	// 		$.each(submenu,function (k,v) {
	// 			$("#searchdiv>ul").append("<li><a href=''#'>"+v+"</a></li>")
	// 			// console.log(k+","+v);
	// 		});
	// 	}
	// });
	// console.log([[${menu_active}]]);
	// window.location.href="/Tradesystem/product/list?menu="+menu;
	window.location.href=contextPath+"/product/list?menu="+menu;



}

//用户中心-发布页tab切换js
function user_change(id){
  for(var i=1;i<=4;i++){
	  document.getElementById("fabucontent"+i).style.display = "none";
	  document.getElementById("fabu"+i).className = "";
	  }
	  document.getElementById("fabucontent"+id).style.display = "block"
	  document.getElementById("fabu"+id).className = "fabu_active_li";
}

//详情页中的视频tab切换JS
function shipin_div(id){
	for(var i=1;i<=2;i++){
		document.getElementById("shipingcontent"+i).style.display = "none";
		document.getElementById("shipin"+i).className = "";
		}
		document.getElementById("shipingcontent"+id).style.display = "block"
		document.getElementById("shipin"+id).className = "detail_shipin_active";
}

//发布--展开收起JS
function showHideUl(obj)
{
	var oDiv=document.getElementById('user_shenhe_drop'+obj);
	var oUl=oDiv.getElementsByTagName('div')[5];
	var oH2=oDiv.getElementsByTagName('span')[0];
	
	if(oUl.style.display == 'none')
	{
		oUl.style.display='block';
		oH2.className='user_shenhe_up';
	}
	else
	{
		oUl.style.display='none';
		oH2.className='user_shenhe_down';
	}
}

//点击数字递增或减少
function add(){
        var txt=document.getElementById("txt");
        var a=txt.value;
        a++;
        txt.value=a;
}
function sub(){
	var txt=document.getElementById("txt");
	var a=txt.value;
	if(a>1){
		a--;
		txt.value=a;
	}else{
		txt.value=1;
	}       
}

// //结算页JS
// window.onload = function ()
// {
// 	//结算页点击使用积分抵扣隐藏展开JS
// 	var ojifenb=document.getElementById('jifen_btn');
// 	var ojifenh=document.getElementById('jifen_hidden');
// 	ojifenb.onclick = function ()
// 	{
// 		if(ojifenh.style.display=='none')
// 		{
// 			ojifenh.style.display='block';
// 			ojifenb.className="jifen_btn_up";
// 		}
// 		else	//none
// 		{
// 			ojifenh.style.display='none';
// 			ojifenb.className="jifen_btn_down";
// 		}
// 	};
//
// 	//结算页支付方式切换JS
// 	var ojiesuan=document.getElementById('userjiesuan_id').getElementsByTagName('dd');
// 	var i=0;
// 	for(i=0;i<ojiesuan.length;i++){
// 		ojiesuan[i].onclick=function(){
// 		for(i=0;i<ojiesuan.length;i++){
// 			ojiesuan[i].className='';
// 		};
// 			this.className='jisuan_active_dd';
// 		};
// 	};
// };

//首页导航和缩策图JS鼠标移入1s事件
$(function(){
	var timer;
	$("#nav_ulwrap li").each(
		function(){
			$(this).hover(
				function(){
					//$(this).find(".down").css("display", "block");		
					var obj = $(this).find(".down");//不能放到定时器里面否则出不来
					timer = setTimeout(function(){ 
						//obj.stop().fadeTo("slow",1,function(){//淡入效果
//							$(this).css("display", "block");
//						})
					obj.show();
					},1000)
				}
				,
				function(){
					var obj = $(this).find(".down");
					 if(timer) {
						  clearTimeout(timer);
						  //obj.stop().fadeTo("slow",0,function(){//淡出效果
//							  $(this).css("display", "none");
//						  })
					  obj.hide();
					  };
				}
			)
		}
	)
})
//鼠标悬停时出现
$(function(){
	var timer1;
	$(".zcq_div .zcq_c1").hover(
		function(event){//event是为了鼠标指针的位置，放在这没用
			//$(this).find(".down").css("display", "block");
			var obj1 = $(this).find(".detail_hidden");//不能放到定时器里面否则出不来

			var tagul=$(this).find(".detail_biaoqian_wrap ul");
			var sid_val=$(this).find(".sucaiid").val();

			var _offsetTop=$(this).offset().top;
			var _offset=$(document).scrollTop();
			timer1 = setTimeout(function(){
				//异步请求查询该素材的所有标签
				$.ajax({
					url:contextPath+"/product/taglist",
					data:{"sid":sid_val},
					dataType:"json",
					type:"get",
					success:function(taglist){
						tagul.empty();
						$.each(taglist,function (k,v) {
							// tagul.append("<li><a href='/Tradesystem/product/list?submenu="+v+"'>"+v+"</a></li>")
							tagul.append("<li><a href='"+contextPath+"/product/list?submenu="+v+"'>"+v+"</a></li>")
						});
					}
				});

				obj1.stop().fadeTo("slow",1,function(){//淡入效果
					$(this).css("display", "block");
				})
				obj1.css("top",(_offset-_offsetTop+$(".scroll_wrap").height()+10)).show().delay(1000);

				//$(".scroll_wrap").height()//就是滚动置顶在窗口顶端的高度，+10代表距离可视区的距离
				//obj.show();
			},1000)
			//alert($(window).scrollTop())//获取滚动条的距离
			//alert($(this).offset().top)//获取块到顶部的距离
		},
		function(){
			var obj1 = $(this).find(".detail_hidden");
			if(timer1) {
				clearTimeout(timer1);
				obj1.stop().fadeTo("slow",0,function(){//淡出效果
					$(this).css("display", "none");
				})
				//obj.hide();
			};
		}
	)


	// $("#img_ulwrap .zcq_div .zcq_c1").hover(
	// 	function(event){//event是为了鼠标指针的位置，放在这没用
	// 		//$(this).find(".down").css("display", "block");
	// 		var obj1 = $(this).find(".detail_hidden");//不能放到定时器里面否则出不来
	//
	// 		var tagul=$(this).find(".detail_biaoqian_wrap ul");
	// 		var sid_val=$(this).find(".sucaiid").val();
	//
	// 		var _offsetTop=$(this).offset().top;
	// 		var _offset=$(document).scrollTop();
	// 		timer1 = setTimeout(function(){
	// 			//异步请求查询该素材的所有标签
	// 			$.ajax({
	// 				url:contextPath+"/product/taglist",
	// 				data:{"sid":sid_val},
	// 				dataType:"json",
	// 				type:"get",
	// 				success:function(taglist){
	// 					tagul.empty();
	// 					$.each(taglist,function (k,v) {
	// 						// tagul.append("<li><a href='/Tradesystem/product/list?submenu="+v+"'>"+v+"</a></li>")
	// 						tagul.append("<li><a href='"+contextPath+"/product/list?submenu="+v+"'>"+v+"</a></li>")
	// 					});
	// 				}
	// 			});
	//
	// 			obj1.stop().fadeTo("slow",1,function(){//淡入效果
	// 				$(this).css("display", "block");
	// 			})
	// 			obj1.css("top",(_offset-_offsetTop+$(".scroll_wrap").height()+10)).show().delay(1000);
	//
	// 			//$(".scroll_wrap").height()//就是滚动置顶在窗口顶端的高度，+10代表距离可视区的距离
	// 		//obj.show();
	// 		},1000)
	// 		//alert($(window).scrollTop())//获取滚动条的距离
	// 		//alert($(this).offset().top)//获取块到顶部的距离
	// 	},
	// 	function(){
	// 		var obj1 = $(this).find(".detail_hidden");
	// 		 if(timer1) {
	// 			  clearTimeout(timer1);
	// 			  obj1.stop().fadeTo("slow",0,function(){//淡出效果
	// 				  $(this).css("display", "none");
	// 			  })
	// 		  //obj.hide();
	// 		  };
	// 	}
	// )
	
})

$(function(){
	var timer2;
	$("#top_xiala li").each(
		function(){
			$(this).hover(
				function(){
					//$(this).find(".down").css("display", "block");		
					var obj2 = $(this).find(".xx_xiala");//不能放到定时器里面否则出不来
					timer2 = setTimeout(function(){ 
						obj2.show();
					},1000)
				}
				,
				function(){
					var obj2 = $(this).find(".xx_xiala");
					 if(timer2) {
						  clearTimeout(timer2);
					  	  obj2.hide();
					  };
				}
			)
		}
	)
})










//交易平台2.0JS
//结算页发票JS
function fapiaoshow(i){
	var fapiao=document.getElementById('fapiaobtn'+i);
	var fapiaohidden=document.getElementById('fapiao_hidden'+i);
	
	if(fapiaohidden.style.display=='none')
	{
		fapiaohidden.style.display='block';
		fapiao.className="fapiao_btn_up";
	}
	else	//none
	{
		fapiaohidden.style.display='none';
		fapiao.className="fapiao_btn_down";
	}
}
$(function(){
	$("#fapiaoinput").click(function(){
		 if($(this).is(":checked"))
		 {
			$("#fapiaohidden").show();
		 }
		 else
		 {
			$("#fapiaohidden").hide();
		 }
	})	
})

//编辑发布页素材类型切换JS
$(function() {
	$("dl.fabu_twozero_qiehuan_dl dd").click(function(){
		$("dl.fabu_twozero_qiehuan_dl dd").removeClass("fabu_twozero_ddactive");
		$(this).addClass("fabu_twozero_ddactive");
	});
});

//编辑发布页都能点击选中的JS
$(function() {
	$("ul.fabu_twozero_ul li").click(function(){
		$(this).toggleClass("fabu_twozero_liactive");
	});
});

//编辑发布页设置价格tab切换
function change(id){
  for(var i=1;i<=3;i++){
  	document.getElementById("pricediv"+i).style.display = "none";
  	document.getElementById("priceli"+i).className = "";
  }
  	document.getElementById("pricediv"+id).style.display = "block"
 	document.getElementById("priceli"+id).className = "fabu_twozero_priceliactive";
}

//编辑发布页textarea剩余字数JS
function changeLength(obj,lg){
	var len = $(obj).val();
	$(obj).next().find("span").text(len.length);
	$(obj).next().find("label").text(len.length);
	//$(obj).next().find("span").text(lg-len.length);//剩余字数
	if(len.length>=lg){
		$(obj).next().find("span").text(70);
		$(obj).next().find("label").text(10);
		$("#ss_sz").text(50);
		$(obj).val(len.substring(0,lg));
	}
}

//编辑发布页修改缩略图的JS
$(function (){
	 $(".fabu_twozero_slt").mouseover(function (){  
            $(".fabu_twozero_sltwrap").show();  
        }).mouseout(function (){  
            $(".fabu_twozero_sltwrap").hide();  
        });  
});

//编辑发布页选择标签点击更多JS
function showmore(i){
	var more=document.getElementById('fabu_twozero_morebtn'+i);
	var morehidden=document.getElementById('fabu_twozero_morehidden'+i);
	
	if(morehidden.style.display=='none')
	{
		morehidden.style.display='block';
		more.className="fabu_twozero_moreup";
	}
	else	//none
	{
		morehidden.style.display='none';
		more.className="fabu_twozero_moredown";
	}
}

//编辑发布页文件格式-对应软件点击其他JS
function fabu_twozeroshowDiv(i){
	document.getElementById('fabu_twozeropopDiv'+i).style.display='block';
	document.getElementById('fabu_twozerobg'+i).style.display='block';
}
function fabu_twozerocloseDiv(i){
	document.getElementById('fabu_twozeropopDiv'+i).style.display='none';
	document.getElementById('fabu_twozerobg'+i).style.display='none';
}

//编辑发布页色系切换JS
$(function() {
	$("ul.fabu_twozero_sexiul li").click(function(){
		//$("ul.fabu_twozero_sexiul li").removeClass("fabu_twozero_sexiactive");
//		$(this).addClass("fabu_twozero_sexiactive");
		var index = $(this).index();
		//$(this).addClass("fabu_twozero_sexiactive").siblings().removeClass("fabu_twozero_sexiactive");
		if(index == 10){
			$(this).addClass("fabu_twozero_sexiactive_10");
			$("ul.fabu_twozero_sexiul li").eq(0).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(1).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(2).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(3).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(4).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(5).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(6).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(7).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(8).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(9).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(11).removeClass("fabu_twozero_sexiactive");
			$("ul.fabu_twozero_sexiul li").eq(12).removeClass("fabu_twozero_sexiactive");
		}
		else{
			$(this).addClass("fabu_twozero_sexiactive").siblings().removeClass("fabu_twozero_sexiactive");
			$(this).addClass("fabu_twozero_sexiactive").siblings().removeClass("fabu_twozero_sexiactive_10");
		}
	});
});

//编辑发布页点击分类JS显示及弹出框里的JS和tab切换
$(function(){
	$(".ftlist_ul li").click(function(){
		$('.ft_content').html($(this).html());
		$('.ft_content').show();
		$('.ft_gang').show();
		$('#fabu_twozeropopDiv3').hide();
		$('#fabu_twozerobg3').hide();
		$('.ftfenlei_yixuan').html($(this).html());
		$('.ftfenlei_yixuan').show();
		$('.ftfenlei_moren').hide();
		
	});
});
$(function() {
	$("ul.ftlist_ul li").click(function(){
		$("ul.ftlist_ul li").removeClass("ftlist_li_active");
		$(this).addClass("ftlist_li_active");
	});
});
function fenlei_div(id){
  for(var i=1;i<=3;i++){
	  document.getElementById("ftfenlei_content"+i).style.display = "none";
	  document.getElementById("fenlei_li"+i).className = "";
  }
	  document.getElementById("ftfenlei_content"+id).style.display = "block"
	  document.getElementById("fenlei_li"+id).className = "ft_tanchuli_active";
}

//编辑发布页视频尺寸和比例切换
$(function() {
	$("dl.fabu_twozero_shipingqiehuan_dl dd").click(function(){
		$("dl.fabu_twozero_shipingqiehuan_dl dd").removeClass("fabu_twozero_ddactive");
		$(this).addClass("fabu_twozero_ddactive");
	});
});



//提现申请页支付宝和银行卡切换
$(function() {
	$("dl.tixian_k1_qiehuan_dl dd").click(function(){
		$("dl.tixian_k1_qiehuan_dl dd").removeClass("tixian_k1_ddactive");
		$(this).addClass("tixian_k1_ddactive");
	});
});

//提现申请页点击数字递增或减少100的倍数
function addk2(){
        var txt=document.getElementById("txt");
        var a=txt.value;
        a=parseInt(a)+parseInt(100);
        txt.value=a;
}
function subk2(){
	var txt=document.getElementById("txt");
	var a=txt.value;
	if(a>100){
		a=parseInt(a)-parseInt(100);
		txt.value=a;
	}else{
		txt.value=100;
	}       
}

//提现申请页点击更换添加卡号和申请提现JS
function tixianshenqingshowDiv(i){
	document.getElementById('tixianshenqing'+i).style.display='block';
	document.getElementById('tixianbg'+i).style.display='block';
}

function tixianshenqingcloseDiv(i){
	document.getElementById('tixianshenqing'+i).style.display='none';
	document.getElementById('tixianbg'+i).style.display='none';
}

//提现申请额度和已有额度对比大小JS
$(function() {
	if(parseFloat($(".tixian_span2").text())<parseFloat($(".tixian_tanchu2_p1").find("span").text())){
		$(".tixian_tanchu2_p3 a").css({"background":"#999999"})
	}
});



//设计师申请页checkbox勾选按钮变亮JS
$(function(){
	$("#designer_xieyiinput").click(function(){
		 if($(this).is(":checked"))
		 {
			$("#designer_join_btn").css("background","#e83a17");
			$("#designer_join_btn").attr("href","javascript:designer_ziliao_show()"); 
		 }
		 else
		 {
			$("#designer_join_btn").css("background","#999999");
			$("#designer_join_btn").attr("href","javascript:void(0)");
		 }
	})	
})

//设计师申请页弹出框勾选按钮变亮JS
$(function(){
	$("#designer_tijiaoxieyi").click(function(){
		 if($(this).is(":checked"))
		 {
			$("#designer_tijiao_btn").css("background","#e83a17");
		 }
		 else
		 {
			$("#designer_tijiao_btn").css("background","#999999");
		 }
	})	
})

//资料弹出框JS
function designer_ziliao_show(){
	document.getElementById('designer_ziliao_content').style.display='block';
	document.getElementById('designer_ziliao_contentbg').style.display='block';
}
function designer_ziliao_close(){
	document.getElementById('designer_ziliao_content').style.display='none';
	document.getElementById('designer_ziliao_contentbg').style.display='none';
}

//设计师申请页弹出框鼠标滑过作品及删除JS
$(function (){
	 $(".designer_shangchuan_anli_ul li").mouseover(function (){
		 	var designer1 = $(this).find(".designer_shangchuan_zhezhao");
            $(designer1).show();  
        }).mouseout(function (){
			var designer1 = $(this).find(".designer_shangchuan_zhezhao");  
            $(designer1).hide();  
        });
		
	var oPopup = $('.delete_tanchu');
	var aBtnTwo = oPopup.find('a');
	$(".designer_shangchuan_anli_ul li .designer_shanchu_a").click(function(){
		var ind=$(this).parents('li').index();//获取designer_shanchu_a对应li祖先元素的索引值
		oPopup.css("display", "block");
		$('.delete_tanchubg').css("display", "block");
		aBtnTwo.eq(1).click(function() {
			oPopup.css("display", "none");
			$('.delete_tanchubg').css("display", "none");
		})
		aBtnTwo.eq(0).click(function() {
		$('.designer_shangchuan_anli_ul li').eq(ind).css("display","none");
			oPopup.css("display", "none");
			$('.delete_tanchubg').css("display", "none");
		})
	})
	
});

//设计师申请页弹出框提现支付宝和银行卡tab切换
$(function(){
	$(".tiqu_ul li").click(function(){
		var index = $(this).index();
		$(this).addClass("tiqu_li_active").siblings().removeClass("tiqu_li_active");
		$(".con").eq(index).addClass("show").siblings().removeClass("show");
	})
});





//详情页鼠标划入产品图出现打赏点赞JS
$(function (){
 $(".pro_detail_position").hover(function(){
    $(".dashang_wrap").css("display","block");
    },function(){
    $(".dashang_wrap").css("display","none");
  });
});

//详情页点赞JS
$(function (){
	$("#dianzan").click(function (){
		//$('#dianzan').attr('href','http://keleyi.com');
		var dianzanvalue = $("#dianzan span").text();
		if(dianzanvalue == "点赞"){
			$("#dianzan span").text('已点赞');
			$("#dianzan span").css("background-image","url(img/dianzan_icon_active.png )");
			$(".dianzan_div").css("background-image","url(img/dashang_bg_active.png )")
		}else{
			$("#dianzan span").text('点赞');
			$("#dianzan span").css("background-image","url(img/dianzan_icon.png )");
			$(".dianzan_div").css("background-image","url(img/dashang_bg.png )")
		}
	})
});

//详情页点击打赏弹出框JS
function dashang_tanchushow(){
	document.getElementById('dashang_tanchu_kuang').style.display='block';
	document.getElementById('dashang_tanchu_kuangbg').style.display='block';
}
function dashang_tanchuclose(){
	document.getElementById('dashang_tanchu_kuang').style.display='none';
	document.getElementById('dashang_tanchu_kuangbg').style.display='none';
}

//详情页点击打赏弹出框里面的选项切换
//$(function() {
//	$("ul.dianzan_ul li").click(function(){
//		$("ul.dianzan_ul li").removeClass("dianzanlist_li_active");
//		$(this).addClass("dianzanlist_li_active");
//	});
//});
//$(function() {
//	$("ul.dianzanzhifu_ul li").click(function(){
//		$("ul.dianzanzhifu_ul li").removeClass("dianzanlist_li_active");
//		$(this).addClass("dianzanlist_li_active");
//	});
//});
//打赏弹出框里面的选择赞赏额度tab切换内容JS
$(function(){
	$(".dianzan_ul li").click(function(){
		var index = $(this).index();
		$(this).addClass("dianzanlist_li_active").siblings().removeClass("dianzanlist_li_active");
		$(".dianzanzhifucon").eq(index).addClass("dianzanzhifushow").siblings().removeClass("dianzanzhifushow");
	})
});

//打赏弹出框里面的支付方式tab切换内容JS
$(function(){
	$(".dianzanzhifu_ul1 li").click(function(){
		var index = $(this).index();
		$(this).addClass("dianzanlist_li_active1").siblings().removeClass("dianzanlist_li_active1");
		$(".dianzanzhifucon1").eq(index).addClass("dianzanzhifushow1").siblings().removeClass("dianzanzhifushow1");
	})
});
$(function(){
	$(".dianzanzhifu_ul2 li").click(function(){
		var index = $(this).index();
		$(this).addClass("dianzanlist_li_active2").siblings().removeClass("dianzanlist_li_active2");
		$(".dianzanzhifucon2").eq(index).addClass("dianzanzhifushow2").siblings().removeClass("dianzanzhifushow2");
	})
});
$(function(){
	$(".dianzanzhifu_ul3 li").click(function(){
		var index = $(this).index();
		$(this).addClass("dianzanlist_li_active3").siblings().removeClass("dianzanlist_li_active3");
		$(".dianzanzhifucon3").eq(index).addClass("dianzanzhifushow3").siblings().removeClass("dianzanzhifushow3");
	})
});

//详情页点击打赏弹出框里面选支付宝支付JS
function zhifubao_zhifu(i){
	document.getElementById('zhifubao_zhifu_wrap'+i).style.display='block';
	document.getElementById('zhifubao_zhifu_bg'+i).style.display='block';
}
function zhifubao_zhifu_close(i){
	document.getElementById('zhifubao_zhifu_wrap'+i).style.display='none';
	document.getElementById('zhifubao_zhifu_bg'+i).style.display='none';
}

//已打赏弹出框
function yidashang(){
	document.getElementById('yidashang').style.display='block';
	document.getElementById('yidashangbg').style.display='block';
}
function yidashang_close(){
	document.getElementById('yidashang').style.display='none';
	document.getElementById('yidashangbg').style.display='none';
}

//打赏成功框
//function dashangchenggong_show(){
//	document.getElementById('dashangchenggong').style.display='block';
//	document.getElementById('dashangchenggong').style.display='block';
//}
function dashangchenggong_close(){
	document.getElementById('dashangchenggong').style.display='none';
	document.getElementById('dashangchenggongbg').style.display='none';
}

//订单点击查看JS
function dingdan2_tanchu_show(){
	document.getElementById('dingdan2_tanchu').style.display='block';
	document.getElementById('dingdan2_tanchubg').style.display='block';
}
function dingdan2_tanchu_close(){
	document.getElementById('dingdan2_tanchu').style.display='none';
	document.getElementById('dingdan2_tanchubg').style.display='none';
}

//订单资源过期JS
function dingdan2_guoqi_show(){
	document.getElementById('dingdan2_guoqi_tanchu').style.display='block';
	document.getElementById('dingdan2_guoqi_tanchubg').style.display='block';
}
function dingdan2_guoqi_close(){
	document.getElementById('dingdan2_guoqi_tanchu').style.display='none';
	document.getElementById('dingdan2_guoqi_tanchubg').style.display='none';
}

//订单删除JS
function dingdan2_shanchu_show(){
	document.getElementById('dingdan2_shanchu_tanchu').style.display='block';
	document.getElementById('dingdan2_shanchu_tanchubg').style.display='block';
}
function dingdan2_shanchu_close(){
	document.getElementById('dingdan2_shanchu_tanchu').style.display='none';
	document.getElementById('dingdan2_shanchu_tanchubg').style.display='none';
}

//用户中心-设计师主页滑过显示上传图片提示和更换背景，头像按钮JS
$(function (){
 $(".user_designer_bg_wrap").hover(function(){
    $(".user_designer_tishi").css("display","block");
	$(".user_designer_genghuan").css("display","block");
	$(".user_designer_genghuan_touxiang").css("display","block");
    },function(){
    $(".user_designer_tishi").css("display","none");
	$(".user_designer_genghuan").css("display","none");
	$(".user_designer_genghuan_touxiang").css("display","none");
  });
});

//用户中心-设计师主-个人推荐发布历史tab切换
function user_designer_change(id){
  for(var i=1;i<=2;i++){
  	document.getElementById("user_designer_home_div"+i).style.display = "none";
  	document.getElementById("user_designer_home_li"+i).className = "";
  }
  	document.getElementById("user_designer_home_div"+id).style.display = "block"
 	document.getElementById("user_designer_home_li"+id).className = "mytitle_twozero_liactive1";
}
//用户中心-设计师主页-推荐里面的取消推荐JS
$(function (){
 $(".zc_list").hover(function(){
	var qxsc = $(this).find(".user_designer_qxsc");
    qxsc.css("display","block");
    },function(){
	var qxsc = $(this).find(".user_designer_qxsc");
    qxsc.css("display","none");
  });
});
$(function (){
	$(".zcq_c1 .user_designer_qxsc .qxsc").click(function (){
		//$('#dianzan').attr('href','http://keleyi.com');
		var qxscvalue = $(this).text();
		if(qxscvalue == "取消推荐"){
			$(this).text('设为收藏');
		}else{
			$(this).text('取消推荐');
		}
	})
});

//用户中心-设计师主页-基本资料性别选择JS
$(function(){
	$(".user_designer_ziliao_ul li").click(function(){
		var index = $(this).index();
		if(index == 0){
			$(this).addClass("user_designer_ziliao_menli");
			$(".user_designer_ziliao_ul li").eq(1).removeClass("user_designer_ziliao_womenli");
		}else if(index == 1){
			$(this).addClass("user_designer_ziliao_womenli");
			$(".user_designer_ziliao_ul li").eq(0).removeClass("user_designer_ziliao_menli");
		}
		//$(".dianzanzhifucon2").eq(index).addClass("dianzanzhifushow2").siblings().removeClass("dianzanzhifushow2");
	})
});

//用户中心-设计师主页-基本资料修改头像鼠标划入JS
$(function (){
 $(".user_designer_ziliao_touxiang_img").hover(function(){
    $(".user_designer_ziliao_tishi").css("display","block");
    },function(){
   $(".user_designer_ziliao_tishi").css("display","none");
  });
});

//用户中心-设计师主页-安全设置解绑编辑JS
function jiebangshow(i){
	var jiebang=document.getElementById('jiebang'+i);
	var jiebanghidden=document.getElementById('jiebang_hidden'+i);
	
	if(jiebanghidden.style.display=='none')
	{
		jiebanghidden.style.display='block';
		jiebang.className="jiebang_up";
	}
	else	//none
	{
		jiebanghidden.style.display='none';
		jiebang.className="jiebang_down";
	}
}
function jiebang_next(){
	var jiebang_nexthidden=document.getElementById('jiebang_next_hidden');
	jiebang_nexthidden.style.display='block';
}

//用户中心-设计师主页-展示推荐和原创tab切换
function user_designer_zhanshichange(id){
  for(var i=1;i<=2;i++){
  	document.getElementById("user_designer_zhanshi_div"+i).style.display = "none";
  	document.getElementById("user_designer_zhanshi_li"+i).className = "";
  }
  	document.getElementById("user_designer_zhanshi_div"+id).style.display = "block"
 	document.getElementById("user_designer_zhanshi_li"+id).className = "mytitle_twozero_liactive";
}

//素材列表页风格对应软件、版本切换JS
$(function() {
	$("ul.pro_list_ul li").click(function(){
		$(this).addClass("pro_list_active_li").siblings().removeClass("pro_list_active_li");
	});
	$("ul.pro_list_ul2 li").click(function(){
		$(this).addClass("pro_list_active_li").siblings().removeClass("pro_list_active_li");
	});
});
//素材列表页色系切换JS
$(function() {
	$("ul.pro_list_ul3 li").click(function(){
		var index = $(this).index();
		if(index == 10){
			$(this).addClass("pro_list_sexi_li_10");
			$("ul.pro_list_ul3 li").eq(0).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(1).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(2).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(3).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(4).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(5).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(6).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(7).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(8).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(9).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(11).removeClass("pro_list_sexi_li");
			$("ul.pro_list_ul3 li").eq(12).removeClass("pro_list_sexi_li");
		}
		else{
			$(this).addClass("pro_list_sexi_li").siblings().removeClass("pro_list_sexi_li");
			$(this).addClass("pro_list_sexi_li").siblings().removeClass("pro_list_sexi_li_10");
		}
	});
});

//头部签到弹出框JS并变成已签到
function qiandaoshow(){
	document.getElementById('qiandaoDiv').style.display='block';
	document.getElementById('qiandaoDivbg').style.display='block';
}
function qiandaoclose(){
	var qiandao = document.getElementById('qiandao_text').innerText;
	if (qiandao == '签到') {
        document.getElementById('qiandao_text').innerText = "已签到";
    }
    //else {
//        document.getElementById('btn'+obj).getElementsByTagName('span')[0].innerText = "关注";
//		guanzhuclass.className='guanzhu_span';
//    }
	document.getElementById('qiandaoDiv').style.display='none';
	document.getElementById('qiandaoDivbg').style.display='none';
}
