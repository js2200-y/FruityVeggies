document.addEventListener('DOMContentLoaded', () => {
    const requestVerificationBtn = document.querySelector('button#requestVerificationBtn');
    requestVerificationBtn.addEventListener('click', async () => {
        const email = document.querySelector('input#email').value;

        if (email === '') {
            alert('이메일을 입력하세요.');
            return;
        }

        const data = { email };
        const reqUrl = '/email/verify';

        try {
            const response = await axios.post(reqUrl, data);
            console.log('response:', response.data);
            toggleRequestButtonState(true); // Toggle request verification button to success state
        } catch (error) {
            console.error(error);
            alert('인증번호 요청에 실패하였습니다.');
        }
    });

    const emailConfirmBtn = document.querySelector('button#emailConfirmBtn');
    emailConfirmBtn.addEventListener('click', async () => {
        const verificationCode = document.querySelector('input#verificationCode').value;

        if (verificationCode === '') {
            alert('인증번호를 입력하세요.');
            return;
        }

        const data = { verificationCode };
        const reqUrl = '/email/confirm';

        try {
            const response = await axios.post(reqUrl, data);
            console.log('response2:', response.data);

            if (response.data.confirmMessage === 'success') {
                toggleButtonState(true); 
                enableSignupButton(); 
            } else {
                toggleButtonState(false); 
                disableSignupButton(); 
            }
        } catch (error) {
            console.error(error);
            alert('인증번호 확인에 실패하였습니다.');
        }
    });

    function toggleRequestButtonState(isSuccess) {
        const requestVerificationBtn = document.querySelector('button#requestVerificationBtn');

        if (isSuccess) {
            requestVerificationBtn.style.backgroundColor = 'green';
            requestVerificationBtn.innerHTML = '요청성공';
        } else {

        }


    }

    function toggleButtonState(isSuccess) {
        const emailConfirmBtn = document.querySelector('button#emailConfirmBtn');

        if (isSuccess) {
            emailConfirmBtn.style.backgroundColor = 'green';
            emailConfirmBtn.innerHTML = '인증 완료';
        } else {
            emailConfirmBtn.style.backgroundColor = 'red';
            emailConfirmBtn.innerHTML = '인증 실패';
        }

    }

    function enableSignupButton() {
        const signupBtn = document.querySelector('#signupBtn');
        signupBtn.disabled = false;
    }

    function disableSignupButton() {
        const signupBtn = document.querySelector('#signupBtn');
        signupBtn.disabled = true;
    }
});
