/**
 * 
 */
 
                $(function () {
                   
			$("#firstHalfYear,#secondHalfYear,#secondHalfYear2020").click(sortMonth);
                  
                })
			function sortMonth(){
                	
                	var res = $(this).attr("class")
         
                    var start;
                	var end;
                	start  = res.substring(0,8);
                	end = res.substring(8);
                	console.log("start="+start+"end="+end);
                	 window.location.href="SortByMonth?start="+start+"&&end="+end;
                	
                }
			