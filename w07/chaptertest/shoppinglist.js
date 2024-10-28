var form = document.getElementById('addForm');
var itemList = document.getElementById('items');
var filter = document.getElementById('filter');

//form submit event
form.addEventListener('submit', addItem);
//delete event
itemList.addEventListener('click', removeItem);
//filter event
filter.addEventListener('keyup', filterItems);

//1. `addItem(e) {}` 함수 내에  id="item" 에 입력된 input 값을 `<li> 태그`로 추가합니다.
//2. 이 때, li 를 생성해서 `appendChild()`와   `.createTextNode(`) 를 사용합니다.
//3. 아이템이 생성된 동시에 삭제 버튼도 `appendChild()`를 사용해서 li에 추가합니다. ( `itemList`에 생성된 li를 추가합니다.)
function addItem(e) {
    e.preventDefault();
    const item = document.getElementById('item').value;
    let li = document.createElement('li');
    li.className = 'list-group-item';

    let text = document.createTextNode(`${item}`);
    li.appendChild(text);

    let btn = document.createElement('button');
    btn.appendChild(document.createTextNode('삭제'));
    btn.className = 'btn btn-danger btn-sm float-right delete';
    //   btn.addEventListener('click', removeItem);

    li.appendChild(btn);
    itemList.appendChild(li);
}

//5. `removeItem(e) {}` 함수 내에 작성합니다.
//6. index.html에`btn btn-danger btn-sm float-right delete` 로 태그된 delete 버튼을 click 하게 될 경우  itemList에서 제거합니다. 이 때 removeChild()를 사용합니다.

function removeItem(e) {
    if (e.target.classList.contains('delete')) {
        if (confirm('정말 제거하실건가요?')) {
            itemList.removeChild(e.target.parentElement);
        }
    }
}

//아이템 진열하기
function filterItems(e) {
    //convert to lowercase
    var text = e.target.value.toLowerCase();
    //get lis
    var items = itemList.getElementsByTagName('li');
    //conver to an array
    Array.from(items).forEach(item => {
        var itemName = item.firstChild.textContent;
        if (itemName.toLowerCase().indexOf(text) != -1) {
            item.style.display = 'block';
        } else {
            item.style.display = 'none';
        }
    });
}
