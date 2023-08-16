/**
 * 
 */
document.addEventListener('DOMContentLoaded', () => {
    const orderRequest = document.getElementById("orderRequest");
    const inputContainer = document.getElementById("inputContainer");
    const customInput = document.getElementById("customInput");


    orderRequest.addEventListener('change', () => {
        if (orderRequest.value === "직접 입력") {
            inputContainer.style.display = "block";
            customInput.setAttribute("required", "true");
        } else {
            inputContainer.style.display = "none";
            customInput.removeAttribute("required");
        }
    });


    const checkBoxBtn = document.getElementById('checkBoxBtn');
    const checkboxImg = document.getElementById('checkboxImg');
    let isChecked = false;

    checkBoxBtn.addEventListener('click', () => {
        isChecked = !isChecked;
        if (isChecked) {
            checkboxImg.src = '/img/checkBoxOff.png'; 
        } else {
            checkboxImg.src = '/img/checkBoxOff.png'; 
        }
    });
   


});
