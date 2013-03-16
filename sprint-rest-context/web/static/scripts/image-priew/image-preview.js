function readURL(input,imageId,ieDivId) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        	var imgObj=document.getElementById(imageId);
        	imgObj.setAttribute('src',e.target.result);
        	imgObj.style.display="block";
        }
        reader.readAsDataURL(input.files[0]);
    }
}