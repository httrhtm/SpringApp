var i = 1;

function addForm(){

	//var answerList = /*[[${answerList}]]*/
	//alert(answerList.get(i).getAnswer);
	//console.log(answerList.get(i).getAnswer);

	var input_data = document.createElement('input');

	//<input id=answerform_i>
	input_data.id = 'answer_' + i;

	//<input class=input_answer>
	input_data.className = 'answerForm';

	//<input type=text>
	input_data.type = 'text';

	//<input name=answer>
	input_data.name = 'answer';

	//form_areatoと一致するidにアクセスする
  	var parent = document.getElementById('form_area');

	//appendChild(): 特定の親要素の中に要素を追加するためのメソッド
	//input_dataをform_areaの中に追加
  	parent.appendChild(input_data);

	//buttonを生成
	var button_data = document.createElement('button');

	//<botton id = i>
  	button_data.id = i;

	button_data.className = 'removeBtn';

	//<input type=button>
	input_data.type = 'text';

  	button_data.onclick = function(){deleteBtn(this);} //クリックされた時の処理

	//innerHTML:既存の要素の内容を新しい内容に置き換えることができる
  	button_data.innerHTML = '削除';


  	//var input_area = document.getElementById(input_data.id);

	//appendChild(): HTML 要素への追加
  	parent.appendChild(button_data);

	//idの数字をプラスする
  	i++ ;
}

function deleteBtn(target) {
  var target_id = target.id;
  var parent = document.getElementById('form_area');
  var input_id = document.getElementById('answer_' + target_id);
  var target_id = document.getElementById(target_id);

	//指定したidのフォームを削除する
  parent.removeChild(input_id);
  parent.removeChild(target_id);
}