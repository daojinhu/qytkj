//主页ajax
(function ($) {
	 /* 后台用户管理 ID:backgroundUserManagement */
  	 $('#backgroundUserManagement'). on('click', function() {
  		 $.ajax({
  	            type:'get',
  	            async:true,
  	            url:"/backStage/user/",
  	            success: function(msg){ 	
  	                //列表数据页面渲染
  	                $('#ContainsRewritingArea').html(msg);
  	            }
  	        });
  	 });
  	 
  	 /* 运维用户管理 ID:ywUserManagement */
  	 $('#ywUserManagement'). on('click', function() {
  		 $.ajax({
  	            type:'get',
  	            async:true,
  	            url:"/backStage/yw/",
  	            success: function(msg){ 	
  	                //列表数据页面渲染
  	                $('#ContainsRewritingArea').html(msg);
  	            }
  	        });
  	 });

   	 /* 用户APP人员管理 ID:yhUserManagement */
   	 $('#yhUserManagement'). on('click', function() {
   		 $.ajax({
   	            type:'get',
   	            async:true,
   	            url:"/backStage/yh/",
   	            success: function(msg){ 	
   	                //列表数据页面渲染
   	                $('#ContainsRewritingArea').html(msg);
   	            }
   	        });
   	 });
   	
   	 /* 机构信息管理 ID:instInfoManagement */
   	 $('#instInfoManagement'). on('click', function() {
   		 $.ajax({
   	            type:'post',
   	            async:true,
   	            url:"/institutionInfo/institutionList",
   	            success: function(msg){
   	                //列表数据页面渲染
   	                $('#ContainsRewritingArea').html(msg);
   	            }
   	        });
   	 });
})(jQuery);





