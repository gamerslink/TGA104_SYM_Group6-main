var size = document.getElementById("size").innerHTML;

for(var i=0 ; i < size  ; i++) {
	let els = [];
	els.push(document.getElementsByClassName("step")[i*4]);
	els.push(document.getElementsByClassName("step")[i*4+1]);
	els.push(document.getElementsByClassName("step")[i*4+2]);
	els.push(document.getElementsByClassName("step")[i*4+3]);
	
	let inner = document.getElementsByClassName("status")[i];
	      let steps = [];
	      Array.prototype.forEach.call(els, (e) => {
	        steps.push(e);
	       
	          progress(inner.innerHTML);
	        
	      });

	      function progress(stepNum) {
	        let p = stepNum * 33;
	        document.getElementsByClassName("percent")[i].style.width = `${p}%`;
	        steps.forEach((e) => {
	          if (e.id <= Number(stepNum)){
	            e.classList.add("completed");
	            e.classList.add('selected');
	          }  
	          
	        
	        });
	      }
	}