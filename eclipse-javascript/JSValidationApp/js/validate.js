/**
 * 
 */

// After form loads focus will go to User id field.
function firstfocus(){
	document.registration.userid.focus();
	return true;
}

// This function will validate User id.
function userid_validation(mx,my){
	var uid= document.registration.userid;
	var uid_len= uid.value.length;
	if (uid_len== 0 || uid_len>= my || uid_len< mx){
		alert("User Id should not be empty / length be between "+mx+" to "+my);
		setTimeout(function() { uid.focus(); }, 100)
		
		return false;
	}
	// Focus goes to next field i.e. Password.
	document.registration.passid.focus();
	return true;
	}

//This function will validate Password.

function passid_validation(mx,my){
	var passid= document.registration.passid;
	var passid_len= passid.value.length;
	if (passid_len== 0 ||passid_len>= my || passid_len< mx){
		alert("Password should not be empty / length be between "+mx+" to "+my);
		setTimeout(function() { passid.focus(); }, 5)
		
		return false;
	}
	// Focus goes to next field i.e. Name.
	
	document.registration.username.focus();
	return true;
	}



//This function will validate Name.

function allLetters(){
	var uname= document.registration.username;
	var letters = /^[A-Za-z]+$/;
	if(uname.value.match(letters)){
		// Focus goes to next field i.e. Address.
		setTimeout(function() { document.registration.address.focus(); }, 100)
		
		return true;
	}else{
		alert('Username must have alphabet characters only');
		setTimeout(function() { uname.focus(); }, 5)
		
		return false;
		}
	}

//This function will validate Address.

function alphanumeric(){
	var uadd= document.registration.address;
	var letters = /^[0-9a-zA-Z]+$/;
	if(uadd.value.match(letters)){
		return true;
	}else{
		alert('User address must have alphanumeric characters only');
		setTimeout(function() { uadd.focus(); }, 5)
		
		return false;
		}
	}


//This function will check whether all fields are not null
function click(){
	var uid= document.registration.userid;
	var uid_len= uid.value.length;
	var passid= document.registration.passid;
	var passid_len= passid.value.length;
	var uname= document.registration.username;
	var uname_len=username.value.length;
	var uadd= document.registration.address;
	var add_len=uadd.value.length;
	if(uid_len==null){
		uid.focus();
		
	}else if(passid_len==null){
		passid.focus();
		
	}else if(uname_len==null){
		username.focus();
		
	}else if(add_len==null){
		address.focus(); 
		
	}else{
		alert("Form Submitted Successfully!");
	}
	
}
















