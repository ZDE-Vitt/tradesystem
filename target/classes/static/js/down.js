// JavaScript Document
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

$(function() {
	if(parseFloat($("dl.down_dl dd:eq(0)").find(".down_dd_price span").text())>parseFloat($("dl.down_dl dd:eq(0)").find(".down_dd_dqprice span").text())){
		$(".down_tishi").show();
		$(".down_btn a").css({"background":"#999999"})
	}
	$("dl.down_dl dd").click(function(){
		$("dl.down_dl dd").removeClass("down_dd_active");
		$(this).addClass("down_dd_active");
		var index=$(this).index("dl.down_dl dd");
		var flag=true;
		if(index==0 || index==1){
			//console.info(parseFloat($(this).find(".down_dd_price span").text()),parseFloat($(this).find(".down_dd_dqprice span").text()))调试用的。
			if(parseFloat($(this).find(".down_dd_price span").text())>parseFloat($(this).find(".down_dd_dqprice span").text())){
				flag=false;
				if(index==0){
					$(".down_tishi").text("您的当前积分不足，请使用其他方式支付");
				}else{
					$(".down_tishi").text("您的当前余额不足，请使用其他方式支付");
				}
			}
		}
		if(!flag){
			$(".down_btn a").css({background:"#999999"});
			$(".down_tishi").show();
		}else{
			$(".down_btn a").css({background:"#e83a17"});
			$(".down_tishi").hide();
		}
	});
});

//下载页支付方式切换JS
window.onload = function ()
{
	var ojiesuan=document.getElementById('userjiesuan_id').getElementsByTagName('dd');
	var i=0;
	for(i=0;i<ojiesuan.length;i++){
		ojiesuan[i].onclick=function(){
		for(i=0;i<ojiesuan.length;i++){
			ojiesuan[i].className='';
		};
			this.className='jisuan_active_dd';
		};
	};
};

