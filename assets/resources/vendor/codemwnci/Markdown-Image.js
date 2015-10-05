function imageLarge(imageLocation,id1,id2){

	var div = document.createElement("div");
	var imageSrc = '<img src="' + imageLocation + '" >';
	var imageId = id1 + id2;
	var image=new Image(); 
 	image.src= imageLocation; 	
	var imageWidth = image.width;
	var htmlText= 
			'<div class="modal fade" id="'+ imageId +'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'+
			'  <div class="modal-dialog" style="width: '+ imageWidth +'px;max-width: 100%">'+
			'    <div class="modal-content">'+
			'      <div class="modal-body">'+ imageSrc +		
			'      </div>'+
			'      <div class="modal-footer ">'+
			'        <button type="button" class="btn btn-primary left" data-dismiss="modal">Close</button>'+
			'      </div>'+
			'    </div><!-- /.modal-content -->'+
			'  </div><!-- /.modal-dialog -->'+
			'</div><!-- /.modal -->';
	div.innerHTML = htmlText;
	document.body.appendChild(div);
	var modalImageId='#'+imageId;
	$(modalImageId).modal('show');

}

function getFileSize(filePath){ 
	var image=new Image(); 
	image.dynsrc=filePath; 
	alert(image.fileSize); 
} 