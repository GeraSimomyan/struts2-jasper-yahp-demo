$(document).ready(function() {
	
	
	/*xmlhttp = new XMLHttpRequest();

	xmlhttp.open("GET", document.URL, true);
	xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4) {
	source = xmlhttp.responseText;
	
	// replace all & with &amp; so that all entities will be visible
	source = source.replace(/&/g,"&amp;");
	// replace all < with &lt; so that all tags will be visible
	//source = source.replace(/[<]/g,"&lt;");
	//source = source.replace('&lt/;',"<");
	}
	}
	xmlhttp.send(null);
	*/
			// Handler for .ready() called.
			$("#pdfDownload").click(function() {
				//alert("Handler for .click() called.");

				var fullHtml = getPageHTML();

				$.post("printPDF", {
					htmlString : fullHtml
					
				});

			});
			
			$("#documentDownload").click(function() {
				//alert("Handler for .click() called.");

				var fullHtml = getPageHTML();

				$.post("documentDownload", {
					htmlString : fullHtml
				});

			});
			
			 $('#print').click(function() {
				  window.print();
				  return false;
				 });
			 
			 $('#back').click(function() {
				  window.history.go(-1);
				  return true;
				 });
			
			function getPageHTML() {
				
				
				
				return "<html>" + document.getElementsByTagName('html')[0].innerHTML + "</html>";
			}
		});


