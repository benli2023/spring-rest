 function readURL(imgFile,divId,ieDivId)
{   
	//if select on IE, then clear the image tag
	var imageObj=document.getElementById(divId);
	if(imageObj) {
		imageObj.setAttribute("src","");
		imageObj.style.display="none";
	}
    var newPreview = document.getElementById(ieDivId);
    newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+imgFile.value+"' ,sizingMethod='scale')";
    newPreview.style.width = "160px";
    newPreview.style.height = "120px";
}