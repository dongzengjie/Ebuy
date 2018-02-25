// JavaScript Document
function change(myid,mode){
	document.getElementById(myid).style.display=mode;
	if(mode == 'block'){
		document.getElementById(myid).style.border="1px solid #eee";
		document.getElementById(myid).style.borderTop="none";
//		document.getElementById(myid).parentNode.style.height="30px";
		document.getElementById(myid).parentNode.style.backgroundColor="#f6f6f6";
//		document.getElementById(myid).parentNode.style.border="1px solid #f6f6f6";
		document.getElementById(myid).parentNode.style.borderBottom="none";
	}
	else{
		document.getElementById(myid).parentNode.style.backgroundColor="";
		document.getElementById(myid).parentNode.style.border="";
	}
}
