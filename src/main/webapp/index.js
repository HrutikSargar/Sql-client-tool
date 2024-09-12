    function selectOnlyThis(id){
  			var myCheckbox = document.getElementsByName("primaryKey");
  			Array.prototype.forEach.call(myCheckbox,function(el){
    		el.checked = false;
    		});
  			id.checked = true;
	}