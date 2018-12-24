       var favVMCodeToSave="";
       var favVMCode="";
       
       function onDeviceReady() {
            window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, gotFSRead, fail);
			 }
			
              
       function gotFSRead(fileSystem) {
           fileSystem.root.getFile("CCappVM.txt", null, gotFileEntryRead, fail);
				 }
       
       function gotFileEntryRead(fileEntry) {
           fileEntry.file(gotFileRead, fail);
					 }
       
		function gotFileRead(file){
			 readAsText(file);
			 }					
		function readAsText(file) {
		         var reader = new FileReader();
				 reader.onloadend = function(evt) {
				     window.localStorage.setItem("favVMCode",evt.target.result);
				 };
				 reader.readAsText(file);
				 }
						
		
		function writeToFile() {
			window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, gotFSWrite, fail);
	    	 }
		
		function gotFSWrite(fileSystem) {
			fileSystem.root.getFile("CCappVM.txt", {create: true, exclusive: false}, gotFileEntryWrite, fail);
		 }
	    
		function gotFileEntryWrite(fileEntry) {
	    	fileEntry.createWriter(gotFileWriter, fail);
	    }
	    
		function gotFileWriter(writer) {
		    var userText = window.localStorage.getItem("favVMCode");//form.userInput.value; // get the text field value
		     writer.seek(writer.length); // get the length of the file; go to end
	    	 writer.write('\n\n' + userText); // skip a space and start writing
	    	 writer.onwriteend = function(evt){
	    	 } 
	    	 readTheFile(); // show new file contents
	    }
	    
	    
	    function deleteContents() {
	    	 window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, gotFSDelete, fail);
	    	 }
	    
	    function gotFSDelete(fileSystem) {
	    	 fileSystem.root.getFile("CCappVM.txt", {create: false, exclusive: false}, gotFileEntryDelete, fail);
	    	 }
	    
	    function gotFileEntryDelete(fileEntry) {
	    	 fileEntry.createWriter(gotFileWriterDelete, fail);
	    	 }

	    function gotFileWriterDelete(writer) {
	         writer.onwriteend = function(evt) {
	    	 writer.truncate(writer.length); // truncate entire file
	    	 writer.onwriteend = function(evt) {
	    	 writer.seek(0); // start at beginning of file
	    	 writer.write(""); // add no content
	    	 writer.onwriteend = function(evt){
	    	 }
	    	 readTheFile(); // show file contents
	    	 };
	    	 };
	    	 writer.write(""); 
	    	 }
	      function fail(error) {
			 console.log(error.code);
			 }