/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateRegEx(regex, input, helpText, helpMessage) {
        // See if the input data validates OK
    if (!regex.test(input)) {
        // The data is invalid, so set the help message and return false
        if (helpText !== null)
        helpText.innerHTML = helpMessage;
          return false;
    }
    else {
        // The data is OK, so clear the help message and return true
        if (helpText !== null)
            helpText.innerHTML = "";
        return true;
    }
}

function validateNonEmpty(inputField, helpText) {
    // See if the input value contains any text
    return validateRegEx(/.+/,inputField.value, helpText,"Please enter a value.");
}
      
function validateDate(inputField, helpText) {
    // First see if the input value contains data
    if (!validateNonEmpty(inputField, helpText))
        return false;

    // Then see if the input value is a date
    return validateRegEx(/^\d{2}\-\d{2}\-(\d{2}|\d{4})$/,inputField.value, helpText,
    "Please enter a date in this format dd-mm-yyyy.");
}
      
function validatePhone(inputField, helpText) {
    // First see if the input value contains data
    if (!validateNonEmpty(inputField, helpText))
        return false;

    // Then see if the input value is a phone number
    return validateRegEx(/^\d{10}$/,inputField.value, helpText,
    "Please enter a proper phone number");
}
      
function validateEmail(inputField, helpText) {
    // First see if the input value contains data
    if (!validateNonEmpty(inputField, helpText))
        return false;

    // Then see if the input value is an email address
    return validateRegEx(/^[\w\.-_\+]+@[\w-]+(\.\w{2,3})+$/,inputField.value, helpText,
    "Please enter a valid email address");
}

function validateZipCode(inputField, helpText) {
        // First see if the input value contains data
        if (!validateNonEmpty(inputField, helpText))
          return false;

        // Then see if the input value is a ZIP code
        return validateRegEx(/^\d{6}$/,
          inputField.value, helpText,
          "Please enter a 6-digit ZIP code.");
      }
function submitform(form) {
    if (
        validateDate(form["date"], form["date_help"]) &&
        validateNonEmpty(form["name"], form["name_help"]) &&
        validatePhone(form["phone"], form["phone_help"]) &&
        validateEmail(form["email"], form["email_help"])) {
        // Submit the order to the server
        form.submit();
        } 
    else {
        alert("I'm sorry but there is something wrong with the order information.");
    }
}