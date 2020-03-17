// JavaScript Document
window.onload = function ()
{	
	//单页下载页支付方式切换JS
	var oxiazai=document.getElementById('xiazai_id').getElementsByTagName('dd');
	var i=0;
	for(i=0;i<oxiazai.length;i++){
		oxiazai[i].onclick=function(){
		for(i=0;i<oxiazai.length;i++){
			oxiazai[i].className='';
			 
			
		};
			this.className='down_dd_active';
		};
	};
	
	
	//结算页点击使用积分抵扣隐藏展开JS
	var downb=document.getElementById('downjifen_btn');
	var downh=document.getElementById('downjifen_hidden');
	downb.onclick = function ()
	{
		if(downh.style.display=='block')
		{
			downh.style.display='none';
		}
		else	//none
		{
			downh.style.display='block';
		}
	};
};

