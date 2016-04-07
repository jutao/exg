/**
 *  inputid textboxid
 *  startYear 起始年
 *  endYear 终止年
 *  path calendar.htm相对路径
 */
function PopUpCalendarDlg(inputid,startYear,endYear,path)
{
	var pattern = /^(19|20)([0-9]){2}$/;
	flag=pattern.test(startYear);
	if(!flag)startYear=1900;
	flag=pattern.test(endYear);
	if(!flag)endYear=2050;

	var currentDate = inputid.value;

	var arguments = new Array(startYear,endYear,0,0,0)

	var pattern = /^(19|20)([0-9]){2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	flag=pattern.test(currentDate);
	if(flag)
	{
		iYear=currentDate.substring(0,4);
		iMonth=currentDate.substring(5,7);
		iDay=currentDate.substring(8,10);
		arguments = new Array(startYear,endYear,iYear,iMonth,iDay)
	}


	showx = event.screenX - event.offsetX + 18;
	showy = event.screenY - event.offsetY - 210;

	var features =
		'dialogWidth:'  + 192 + 'px;' +
		'dialogHeight:' + 210 + 'px;' +
		'dialogLeft:'   + showx     + 'px;' +
		'dialogTop:'    + showy     + 'px;' +
		'directories:no; localtion:no; menubar:no; status=no; toolbar=no;scrollbars:yes;Resizeable=no';
        
	retval = window.showModalDialog(path + "calendar.htm", arguments , features );

        var control=eval(inputid)
	if( retval != null ){
               control.value=retval;
	}else{
		//alert("canceled");
	}
}
