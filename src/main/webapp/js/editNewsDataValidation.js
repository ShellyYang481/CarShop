/**
 * 
 */
  $(function(){
     validateData();
       });
    

    	
    
    function validateData(){
    	let warning = "不可為空白!";
    	let success = "正確";
        $("#title").blur(function(){
   
         	var title = $("#title").val().trim(); 
     
         	if (title == ""){
               $("#sp1").html(warning);
            $("#sp1").next().attr("src","image/error.png");
             }else if (title!=""){
             $("#sp1").html(success);
             $("#sp1").next().attr("src","image/greencheck.jpg");
             }
           
        })
        $("#subtitle").blur(function(){

         	var subtitle = $("#subtitle").val().trim(); 
         	if (subtitle == ""){
               $("#sp2").html(warning);
                $("#sp2").next().attr("src","image/error.png");
             }else if (subtitle!=""){
                 $("#sp2").html(success);
                  $("#sp2").next().attr("src","image/greencheck.jpg");
             }
        })
        
         $("#uploaddate").blur(function(){
 
         	var uploaddate = $("#uploaddate").val().trim(); 
         	if (uploaddate == ""){
               $("#sp3").html(warning);
                $("#sp3").next().attr("src","image/error.png");
             }else if (uploaddate!=""){
                 $("#sp3").html(success);
                  $("#sp3").next().attr("src","image/greencheck.jpg");
                  }
        })
              $("#content").blur(function(){
    
         	var content = $("#content").val().trim(); 
         	if (content == ""){
               $("#sp4").html(warning);
                $("#sp4").next().attr("src","image/error.png");
             }else if (content!=""){
               $("#sp4").html(success);
                $("#sp4").next().attr("src","image/greencheck.jpg");
                }
        })
        
    	$("#submitid").click(function(){
    	let title = $("#title").val().trim();
    	let subtitle = $("#subtitle").val().trim();
    	let uploadDate = $("#uploaddate").val().trim();
    	let content = $("#content").val().trim();
	
		if (title == "" && subtitle== "" && uploadDate== "" && content== ""){
	$("#sp1,#sp2,#sp3,#sp4").html(warning);
	$("#sp1,#sp2,#sp3,#sp4").next().attr("src","image/error.png");
	return false;
	}else if(title == ""||subtitle==""||uploadDate==""||content==""){
    	if(title == ""){
    		$("#sp1").html(warning);
    		$("#sp1").next().attr("src","image/error.png");
    		return false;}
    	if (subtitle==""){
    	$("#sp2").html(warning);
    	$("#sp2").next().attr("src","image/error.png");
    	return false;
    	}
    	if (uploadDate==""){
    		$("#sp3").html(warning);
    		$("#sp3").next().attr("src","image/error.png");
    		return false;
    	}
    	if (content==""){
    	$("#sp4").html(warning);
    	$("#sp4").next().attr("src","image/error.png");
    	return false;
    	}
	}
    	else
    	return true;
    
    	
    })}