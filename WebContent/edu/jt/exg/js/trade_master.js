function checkFormForCreateOrUpdate(){
	//必填项

	

	//正整数
	
			var quantity=$("#quantity").val();
		quantity=trim(quantity);
		if(quantity!=''){
			if(isNumber(quantity)==false){
				alert('quantity must be positive number!');
				return false;
			}
		}
		$("#quantity").val(quantity);
		
		var invalid=$("#invalid").val();
		invalid=trim(invalid);
		if(invalid!=''){
			if(isNumber(invalid)==false){
				alert('invalid must be positive number!');
				return false;
			}
		}
		$("#invalid").val(invalid);
		


	//正小数
	
			var subscription_fees=$("#subscription_fees").val();
		subscription_fees=trim(subscription_fees);
		if(subscription_fees!=''){
			if(isPositiveDecimal(subscription_fees)==false){
				alert('subscription_fees number must be positive decimal!');
				return false;
			}
		}
		$("#subscription_fees").val(subscription_fees)
		
		var total_amount=$("#total_amount").val();
		total_amount=trim(total_amount);
		if(total_amount!=''){
			if(isPositiveDecimal(total_amount)==false){
				alert('total_amount number must be positive decimal!');
				return false;
			}
		}
		$("#total_amount").val(total_amount)
		
		var redemption_amount=$("#redemption_amount").val();
		redemption_amount=trim(redemption_amount);
		if(redemption_amount!=''){
			if(isPositiveDecimal(redemption_amount)==false){
				alert('redemption_amount number must be positive decimal!');
				return false;
			}
		}
		$("#redemption_amount").val(redemption_amount)
		
		var redemption_fees=$("#redemption_fees").val();
		redemption_fees=trim(redemption_fees);
		if(redemption_fees!=''){
			if(isPositiveDecimal(redemption_fees)==false){
				alert('redemption_fees number must be positive decimal!');
				return false;
			}
		}
		$("#redemption_fees").val(redemption_fees)
		
		var payment_money=$("#payment_money").val();
		payment_money=trim(payment_money);
		if(payment_money!=''){
			if(isPositiveDecimal(payment_money)==false){
				alert('payment_money number must be positive decimal!');
				return false;
			}
		}
		$("#payment_money").val(payment_money)
		


	//editor处理
	
	

	//上传处理
	
	

	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
	
	
	//手动timestamp的时、分处理
	
			$("#purchase_timeHour").val($("#purchase_timeHourSelect").find("option:selected").val());
		$("#purchase_timeMinute").val($("#purchase_timeMinuteSelect").find("option:selected").val());
		
		$("#redemption_timeHour").val($("#redemption_timeHourSelect").find("option:selected").val());
		$("#redemption_timeMinute").val($("#redemption_timeMinuteSelect").find("option:selected").val());
		
		$("#payment_timeHour").val($("#payment_timeHourSelect").find("option:selected").val());
		$("#payment_timeMinute").val($("#payment_timeMinuteSelect").find("option:selected").val());
		

	return true;
}

function checkFormForQuery(){
	//正整数
	
			var quantityFrom=$("#quantityFrom").val();
		quantityFrom=trim(quantityFrom);
		if(quantityFrom!=''){
			if(isNumber(quantityFrom)==false){
				alert('quantityFrom must be positive number!');
				return false;
			}
		}
		$("#quantityFrom").val(quantityFrom);
		var quantityTo=$("#quantityTo").val();
		quantityTo=trim(quantityTo);
		if(quantityTo!=''){
			if(isNumber(quantityTo)==false){
				alert('quantityTo must be positive number!');
				return false;
			}
		}
		$("#quantityTo").val(quantityTo);
		
		var invalidFrom=$("#invalidFrom").val();
		invalidFrom=trim(invalidFrom);
		if(invalidFrom!=''){
			if(isNumber(invalidFrom)==false){
				alert('invalidFrom must be positive number!');
				return false;
			}
		}
		$("#invalidFrom").val(invalidFrom);
		var invalidTo=$("#invalidTo").val();
		invalidTo=trim(invalidTo);
		if(invalidTo!=''){
			if(isNumber(invalidTo)==false){
				alert('invalidTo must be positive number!');
				return false;
			}
		}
		$("#invalidTo").val(invalidTo);
		


	//正小数
	
			var subscription_feesFrom=$("#subscription_feesFrom").val();
		subscription_feesFrom=trim(subscription_feesFrom);
		if(subscription_feesFrom!=''){
			if(isPositiveDecimal(subscription_feesFrom)==false){
				alert('subscription_feesFrom number must be positive decimal!');
				return false;
			}
		}
		$("#subscription_feesFrom").val(subscription_feesFrom);
		var subscription_feesTo=$("#subscription_feesTo").val();
		subscription_feesTo=trim(subscription_feesTo);
		if(subscription_feesTo!=''){
			if(isPositiveDecimal(subscription_feesTo)==false){
				alert('subscription_feesTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#subscription_feesTo").val(subscription_feesTo);
		var total_amountFrom=$("#total_amountFrom").val();
		total_amountFrom=trim(total_amountFrom);
		if(total_amountFrom!=''){
			if(isPositiveDecimal(total_amountFrom)==false){
				alert('total_amountFrom number must be positive decimal!');
				return false;
			}
		}
		$("#total_amountFrom").val(total_amountFrom);
		var total_amountTo=$("#total_amountTo").val();
		total_amountTo=trim(total_amountTo);
		if(total_amountTo!=''){
			if(isPositiveDecimal(total_amountTo)==false){
				alert('total_amountTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#total_amountTo").val(total_amountTo);
		var redemption_amountFrom=$("#redemption_amountFrom").val();
		redemption_amountFrom=trim(redemption_amountFrom);
		if(redemption_amountFrom!=''){
			if(isPositiveDecimal(redemption_amountFrom)==false){
				alert('redemption_amountFrom number must be positive decimal!');
				return false;
			}
		}
		$("#redemption_amountFrom").val(redemption_amountFrom);
		var redemption_amountTo=$("#redemption_amountTo").val();
		redemption_amountTo=trim(redemption_amountTo);
		if(redemption_amountTo!=''){
			if(isPositiveDecimal(redemption_amountTo)==false){
				alert('redemption_amountTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#redemption_amountTo").val(redemption_amountTo);
		var redemption_feesFrom=$("#redemption_feesFrom").val();
		redemption_feesFrom=trim(redemption_feesFrom);
		if(redemption_feesFrom!=''){
			if(isPositiveDecimal(redemption_feesFrom)==false){
				alert('redemption_feesFrom number must be positive decimal!');
				return false;
			}
		}
		$("#redemption_feesFrom").val(redemption_feesFrom);
		var redemption_feesTo=$("#redemption_feesTo").val();
		redemption_feesTo=trim(redemption_feesTo);
		if(redemption_feesTo!=''){
			if(isPositiveDecimal(redemption_feesTo)==false){
				alert('redemption_feesTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#redemption_feesTo").val(redemption_feesTo);
		var payment_moneyFrom=$("#payment_moneyFrom").val();
		payment_moneyFrom=trim(payment_moneyFrom);
		if(payment_moneyFrom!=''){
			if(isPositiveDecimal(payment_moneyFrom)==false){
				alert('payment_moneyFrom number must be positive decimal!');
				return false;
			}
		}
		$("#payment_moneyFrom").val(payment_moneyFrom);
		var payment_moneyTo=$("#payment_moneyTo").val();
		payment_moneyTo=trim(payment_moneyTo);
		if(payment_moneyTo!=''){
			if(isPositiveDecimal(payment_moneyTo)==false){
				alert('payment_moneyTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#payment_moneyTo").val(payment_moneyTo);

	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
	

	//手动timestamp的时、分处理
	
			$("#purchase_timeHourFrom").val($("#purchase_timeHourSelectFrom").find("option:selected").val());
		$("#purchase_timeMinuteFrom").val($("#purchase_timeMinuteSelectFrom").find("option:selected").val());
		$("#purchase_timeHourTo").val($("#purchase_timeHourSelectTo").find("option:selected").val());
		$("#purchase_timeMinuteTo").val($("#purchase_timeMinuteSelectTo").find("option:selected").val());
		
		$("#redemption_timeHourFrom").val($("#redemption_timeHourSelectFrom").find("option:selected").val());
		$("#redemption_timeMinuteFrom").val($("#redemption_timeMinuteSelectFrom").find("option:selected").val());
		$("#redemption_timeHourTo").val($("#redemption_timeHourSelectTo").find("option:selected").val());
		$("#redemption_timeMinuteTo").val($("#redemption_timeMinuteSelectTo").find("option:selected").val());
		
		$("#payment_timeHourFrom").val($("#payment_timeHourSelectFrom").find("option:selected").val());
		$("#payment_timeMinuteFrom").val($("#payment_timeMinuteSelectFrom").find("option:selected").val());
		$("#payment_timeHourTo").val($("#payment_timeHourSelectTo").find("option:selected").val());
		$("#payment_timeMinuteTo").val($("#payment_timeMinuteSelectTo").find("option:selected").val());
		

	
	//自动timestamp的时、分处理
	
			$("#register_timeHourFrom").val($("#register_timeHourSelectFrom").find("option:selected").val());
		$("#register_timeMinuteFrom").val($("#register_timeMinuteSelectFrom").find("option:selected").val());
		$("#register_timeHourTo").val($("#register_timeHourSelectTo").find("option:selected").val());
		$("#register_timeMinuteTo").val($("#register_timeMinuteSelectTo").find("option:selected").val());
		
		$("#update_timeHourFrom").val($("#update_timeHourSelectFrom").find("option:selected").val());
		$("#update_timeMinuteFrom").val($("#update_timeMinuteSelectFrom").find("option:selected").val());
		$("#update_timeHourTo").val($("#update_timeHourSelectTo").find("option:selected").val());
		$("#update_timeMinuteTo").val($("#update_timeMinuteSelectTo").find("option:selected").val());
		

	return true;
}

function finder(){
	if(checkFormForQuery()==true){
		$("#start").val('0');
		var form=$("#form1");
		$("#trid").css('display','none'); 
		$("#load").css('display','');
		form.submit();
	}
}

function submit(formId,actionStr){
		$("#trid").css('display','none'); 
		$("#load").css('display','');
		$("#" + formId).attr("action", actionStr).submit();
}