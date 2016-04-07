// treeMain.js

function show(){
		top.document.getElementById("display").style.display='none';
		top.document.getElementById("main").style.display='none';
		top.document.getElementById("treeTd").width= screen.availWidth;
		document.getElementById("tree").width = 990;
		document.getElementById("show").style.display = 'none';	
		document.getElementById("resume").style.display = '';
}
function resume(){
		top.document.getElementById("display").style.display='';
		top.document.getElementById("main").style.display='';
		top.document.getElementById("treeTd").width= 200;
		document.getElementById("tree").width= 190;
		document.getElementById("resume").style.display = 'none';
		document.getElementById("show").style.display = '';
}
function hideTree(){
		document.getElementById("treeTd").style.display='none';
		document.getElementById("rallow").style.display='';
		document.getElementById("lallow").style.display='none';
}
function showTree(){
		document.getElementById("treeTd").style.display='';
		document.getElementById("rallow").style.display='none';
		document.getElementById("lallow").style.display='';
}

