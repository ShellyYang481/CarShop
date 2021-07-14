/**
 * 
 */
  $(function(){
    	autofill();
     validateData();
       });
    
    function autofill(){
    	
    	 $("#btn").click(function(){
    		 var text1 = "開啟電創未來的四環純電科技核心，Audie-tron智能充電與熱能管理系統";
    		 text1 = $("#title").val(text1);
    		 var text2 = "全能電旅 Audi e-tron 於 12 月初正式在台上市，為四環實現純電生活圈的品牌願景跨出關鍵第一步";
         	 text2=$("#subtitle").val(text2);
    		 var text3 = "2021-03-09";
    		 text3=$("#uploaddate").val(text3);
    		 var text4 = "全能電旅 Audi e-tron 於 12 月初正式在台上市，為四環實現純電生活圈的品牌願景跨出關鍵第一步。如同 Audi 於 2019 年舉辦的科技電動日 (TechDay Insight e-mobility) 中所揭示的品牌發展願景：「未來將是純電移動的時代。Audi 將以頂尖科技引領車壇，持續推動能滿足日常實用性的純電車款。」對於電動車款來說，穩定且可靠的充電系統更是不可或缺的神經中樞，全能電旅 Audi e-tron 如何透過完美運作的先進智能充電與熱能管理系統，提供車輛足夠電能以滿足不同的行駛需求，更是開啟電創未來新時代最重要的基礎。";
    		 text4=$("#content").val(text4)
    		 var text5 = "先進熱能管理系統提供更快的充電速度與效率";
    		 text5=$("#remarks").val(text5);
         })
    	
    }
    function validateData(){
    	let warning = "不可為空白!";
    	let success = "正確";
        $("#title").blur(function(){
   
         	var title = $("#title").val().trim(); 
     
         	if (title == ""){
               $("#sp1").html(warning);
            $("#sp1").next().attr("src","../image/error.png");
             }else if (title!=""){
             $("#sp1").html(success);
             $("#sp1").next().attr("src","../image/greencheck.jpg");
             }
           
        })
        $("#subtitle").blur(function(){

         	var subtitle = $("#subtitle").val().trim(); 
         	if (subtitle == ""){
               $("#sp2").html(warning);
                $("#sp2").next().attr("src","../image/error.png");
             }else if (subtitle!=""){
                 $("#sp2").html(success);
                  $("#sp2").next().attr("src","../image/greencheck.jpg");
             }
        })
        
         $("#uploaddate").blur(function(){
 
         	var uploaddate = $("#uploaddate").val().trim(); 
         	if (uploaddate == ""){
               $("#sp3").html(warning);
                $("#sp3").next().attr("src","../image/error.png");
             }else if (uploaddate!=""){
                 $("#sp3").html(success);
                  $("#sp3").next().attr("src","../image/greencheck.jpg");
                  }
        })
              $("#content").blur(function(){
    
         	var content = $("#content").val().trim(); 
         	if (content == ""){
               $("#sp4").html(warning);
                $("#sp4").next().attr("src","../image/error.png");
             }else if (content!=""){
               $("#sp4").html(success);
                $("#sp4").next().attr("src","../image/greencheck.jpg");
                }
        })
        
    	$("#submitid").click(function(){
    	let title = $("#title").val().trim();
    	let subtitle = $("#subtitle").val().trim();
    	let uploadDate = $("#uploaddate").val().trim();
    	let content = $("#content").val().trim();
	
		if (title == "" && subtitle== "" && uploadDate== "" && content== ""){
	$("#sp1,#sp2,#sp3,#sp4").html(warning);
	$("#sp1,#sp2,#sp3,#sp4").next().attr("src","../image/error.png");
	return false;
	}else if(title == ""||subtitle==""||uploadDate==""||content==""){
    	if(title == ""){
    		$("#sp1").html(warning);
    		$("#sp1").next().attr("src","../image/error.png");
    		return false;}
    	if (subtitle==""){
    	$("#sp2").html(warning);
    	$("#sp2").next().attr("src","../image/error.png");
    	return false;
    	}
    	if (uploadDate==""){
    		$("#sp3").html(warning);
    		$("#sp3").next().attr("src","../image/error.png");
    		return false;
    	}
    	if (content==""){
    	$("#sp4").html(warning);
    	$("#sp4").next().attr("src","../image/error.png");
    	return false;
    	}
	}
    	else
    	return true;
    
    	
    })}