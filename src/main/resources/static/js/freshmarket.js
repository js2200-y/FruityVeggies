/**
 * 
 */
 document.addEventListener('DOMContentLoaded', ()=> {
	 
	 const formSelect = document.querySelector('#form-select');
	 const action = document.querySelector('#action');
	 
	 const selectedOptionsSet = new Set();
	 const price = document.querySelector('dd.price');
	 const priceText = price.textContent;
	 const numbersOnly = priceText.replace(/\D/g, '');

            formSelect.addEventListener('change', (e) => {
                console.log('opt');
                console.log(price.innerHTML);
                const selectedOption = e.target.value;
                const optionText = `못난이 파프리카/${selectedOption}`;
                
                if (!selectedOptionsSet.has(optionText)) {
                    selectedOptionsSet.add(optionText);
                    const div = document.createElement("div");
                    div.innerHTML = `<p>${optionText}</p>
                    				<button type="button" class="btn" id="button">-</button>
                    				<input type="number" class="numBox" min="1" max="10" value="1" readonly="readonly" />
                    				<button type="button" class="btn" id="button">+</button>
                    				<label>${numbersOnly}원</label>
                    				<p><p>`;
                    action.appendChild(div);
                }
	 });
 });