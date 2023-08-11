/**
 * 
 */
 document.addEventListener('DOMContentLoaded', ()=> {
	
	// 폼 전체 
    const formSelect = document.querySelector('#form-select');
    
    // 옵션 디테일 영역
    const opDetailArea = document.querySelector('#opDetailArea');
    
    // 옵션 선택 항목 저장 객체
    const selectedOptionsSet = new Set();
    
    // 최종 상품 금액을 출력할 영역
    const totalPrice = document.querySelector('.result_price');
    let totalAmount = 0;// 최종 값
    
// 셀렉트 박스 이벤트 리스너 시작    
    // 섹렉트 박스 옵션 변경 시 처리
    formSelect.addEventListener('change', (e) =>{
        
    const selectedOption_value = e.target.value;
    const selectedOption_text = e.target[e.target.selectedIndex].textContent;
    
    console.log('selectedOption_value : '+selectedOption_value);// 30000
    console.log('selectedOption_text : '+selectedOption_text);//유기농 송이바나나 3.5kg 30000원
    
    // 옵션 디테일 영역에 들어감 text 
    const opDetailText = selectedOption_text.replace(/ /g, '_');
    console.log('opDetailText : '+opDetailText)

    if (! (selectedOptionsSet.has(opDetailText) || selectedOption_text =='옵션을 선택해주세요')) {// 없는 옵션을 선택하면 아래실행()
    
        selectedOptionsSet.add(opDetailText);

        

        const div = document.createElement("div");
                    div.innerHTML = `<p>${opDetailText}</p>
                                <button type="button" class="minus btn" id="minus_${opDetailText}" value="${selectedOption_value}">-</button>
                                <input type="number" class="numBox" id="numBox_${opDetailText}" min="1" max="10" value="1"  readonly="readonly" />
                                <button type="button" class="plus btn" id="plus_${opDetailText}" value="${selectedOption_value}">+</button>
                                <label id="numbers_${opDetailText}">${opDetailText}</label><label>원</label>`;
        opDetailArea.appendChild(div);

        const plus = document.querySelector(`#plus_${opDetailText}`);
        console.log('plus111111111111111 : '+plus);
        const minus = document.querySelector(`#minus_${opDetailText}`);
        const numBox = document.querySelector(`#numBox_${opDetailText}`);
        
        // 한 옵션 합산 가격
        const price_label = document.querySelector(`#numbers_${opDetailText}`).value;
        
       //console.log('price_label 값 : '+Number(price_label.textContent.replace(/\D/g, ''))); 

/*플러스 버튼 시작*/        
        plus.addEventListener('click', () =>{
            const num = numBox.value;
                const plusNum = Number(num) + 1;
                console.log('number'+plusNum);
          
               if(plusNum >= 10) {
                        numBox.value = 10;
                        price_label.innerHTML = selectedOption_value*10;
               } else {
                        numBox.value = plusNum;
                        price_label.innerHTML = selectedOption_value*plusNum;
               }
               
               totalAmount += Number(price_label.innerHTML.replace(/\D/g, ''));
               // 1번라벨, 2번라벨, 3번 라벨
               // 1번 +, - 를 누르면 3000+
               // 2번 +, - 를 누르면 6000+
               // 3번 +, - 를 누르면 9000+
               
               console.log(totalAmount);
                console.log('testtesttesttesttesttest2 : '+Number(price_label.textContent.replace(/\D/g, '')));
               totalAmount = Number(document.querySelector(`#numbers_${optionText}`).textContent.replace(/\D/g, ''));
               //numbers_못난이파프리카_1kg
               /*const oa1 = 'numbers_못난이파프리카_'+e.target[formSelect.options.length].textContent;*/
               console.log('formSelect.options.length:'+formSelect.options.length);
               
               
               
               console.log('asdfasdfasdfasdf:'+'numbers_못난이파프리카_'+e.target[formSelect.options.length-1].textContent);
               
               totalPrice.innerHTML = totalAmount;
               
             });        
/*플러스 버튼 끝*/  

/*마이너스 버튼 시작*/
           minus.addEventListener('click', () =>{
              var num = numBox.value;
              var minusNum = Number(num) - 1;
   
              if(minusNum <= 1) {
                    numBox.value = 1;
                    price_label.innerHTML = selectedOption_value*1; // Update label 
               } else {
                   numBox.value = minusNum;
                    price_label.innerHTML = selectedOption_value*minusNum; // Update label       
              }
              
            totalAmount -=Number(price_label.innerHTML.replace(/\D/g, '')); 
            
            console.log('testtesttesttesttesttest3 : '+Number(price_label.textContent.replace(/\D/g, '')));
            totalPrice.innerHTML = totalAmount;
          });
/*마이너스 버튼 끝*/
   
    }                      
                                
    });
// 셀렉트 박스 이벤트 리스너 끝    
    	 
 });