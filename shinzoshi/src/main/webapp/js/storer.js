function createXmlHttpRequest(){
    if(window.XMLHttpRequest){
        return new XMLHttpRequest();
    }else{
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

//移除元素
function clearContent(){  
	var contentTable = document.getElementById('content_table_body'); 
	var size=contentTable.childNodes.length;  
	if(size!=0){
		for(var i=size-1;i>=0;i--){  
		    contentTable.removeChild(contentTable.childNodes[i]);  
		}
	}
}   

//添加元素
function setContents(contents){  
	      clearContent();  
	       var size= contents.length; 
	       var aaaa=eval("("+contents+")");
		      for (i=0;i<aaaa.length;i++){		    	  
		    	  var tr=document.createElement("tr");  
		           
		           var td=document.createElement("td");  
		           var text= document.createTextNode(aaaa[i].storerkey);
		           td.appendChild(text);  
		           tr.appendChild(td); 
		           
		           var td=document.createElement("td");  
		           var text= document.createTextNode(aaaa[i].company);
		           td.appendChild(text);  
		           tr.appendChild(td);
		           
		           var td=document.createElement("td");  
		           var text= document.createTextNode(aaaa[i].phone);
		           td.appendChild(text);  
		           tr.appendChild(td);
		           
		           var td=document.createElement("td");  
		           var text= document.createTextNode(aaaa[i].address);
		           td.appendChild(text);  
		           tr.appendChild(td);
		           
		           var td=document.createElement("td");  
		           var text= document.createTextNode(aaaa[i].email);
		           td.appendChild(text);  
		           tr.appendChild(td);
		           
		           var td=document.createElement("td");  
		           var text= document.createTextNode(aaaa[i].comment);
		           td.appendChild(text);  
		           tr.appendChild(td);
		           
		           //操作
		           var td=document.createElement("td");  
		           var a=document.createElement("a"); 
		           a.href="/storer/delete/"+aaaa[i].storerkey;
		          // a.onclick=confirmDel(aaaa[i].storerkey);
		           //a.href="javascript:void(0)";
		           a.innerHTML="删除 ";
		           td.appendChild(a);
		           
		           var b=document.createElement("a"); 
		           b.href="/storer/toUpdateStorerPage/"+aaaa[i].storerkey;
		           b.innerHTML=" 修改";
		           td.appendChild(b);
		           
		           tr.appendChild(td);

		           document.getElementById("content_table_body").appendChild(tr); 
		      }
}  
/*
function confirmDel(id){
	var isConfirm = window.confirm("确认删除吗？想好了吗？");
	if(isConfirm){
		// 提交删除链接
		location.href="/storer/delete/"+id;
	}	
}
*/
window.onload=function(){
	var url="findAll";
	//调用方法创建XMLHttpRequest对象
	XmlHttpRequest = createXmlHttpRequest();
	//设置回调函数
	XmlHttpRequest.onreadystatechange=callbackStorerFindAll;
	//初始化xmlhttprequest
	XmlHttpRequest.open("POST",url,true);
	//发送请求
	XmlHttpRequest.send(null);
}

//回调函数
function callbackStorerFindAll(){
	if(XmlHttpRequest.readyState == 4&& XmlHttpRequest.status == 200){
		var result = XmlHttpRequest.responseText;
		//alert(result);
		setContents(result);
	}
}
