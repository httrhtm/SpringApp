var i = 1;

function addForm() {
	var input_data = document.createElement('input');
  	input_data.type = 'text';
  	input_data.id = 'answer' + i;
	input_data.name = 'answer';
	input_data.className = 'answerForm';
  	var parent = document.getElementById('form_area');
  	parent.appendChild(input_data);

  	var input_data2 = document.createElement('input');
  	input_data2.type = 'hidden';
  	input_data2.id = 'answer_id' + i;
	input_data2.name = 'answer_id';
	input_data2.value = 0;
 	parent.appendChild(input_data2);

	var button_data = document.createElement('button');
 	button_data.id = i;
 	name = 'delete';
  	button_data.onclick = function(){deleteBtn(this);}
  	button_data.innerHTML = '削除';
  	parent.appendChild(button_data);

  	i++ ;
}

function deleteBtn(target) {
  var target_id = target.id;
  var parent = document.getElementById('form_area');
  var input_id = document.getElementById('answer' + target_id);
  var target_id = document.getElementById(target_id);

	//指定したidのフォームを削除する
  	parent.removeChild(input_id);
  	parent.removeChild(target_id);
}