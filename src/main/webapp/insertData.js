/*  // Function to create a new row with the same number of input tags
  function createNewRow() {
    const row = document.createElement('div');
    row.classList.add('row');
    const inputElements = document.querySelectorAll('.row:last-of-type input');
    inputElements.forEach(function(input) {
      const newInput = document.createElement('input');
      newInput.type = 'text';
      newInput.placeholder = 'Enter text';
      row.appendChild(newInput);
    });
    document.getElementById('container').appendChild(row);
  }

  // Event listener function
  function handleInputClick(event) {
    createNewRow();
  }

  // Attach event listener to initial input element
  document.addEventListener('DOMContentLoaded', function() {
    const inputElements = document.querySelectorAll('#container input');
    inputElements.forEach(function(input) {
      input.addEventListener('click', handleInputClick);
    });
  });*/
  
   // Function to create a new row with the same number of input tags
  function createNewRow() {
    const row = document.createElement('div');
    row.classList.add('row');
    const inputElements = document.querySelectorAll('.row:last-of-type input');
    inputElements.forEach(function(input) {
      const newInput = document.createElement('input');
      newInput.type = 'text';
      newInput.placeholder = 'Enter text';
      row.appendChild(newInput);
    });
    document.getElementById('container').appendChild(row);
  }

  // Event listener function
  function handleInputClick(event) {
    const rows = document.querySelectorAll('.row');
    const lastRow = rows[rows.length - 1];
    const lastRowInputElements = lastRow.querySelectorAll('input');
    if (event.target === lastRowInputElements[lastRowInputElements.length - 1]) {
      createNewRow();
    }
  }

  // Attach event listener to initial input element
  document.addEventListener('DOMContentLoaded', function() {
    const inputElements = document.querySelectorAll('#container input');
    inputElements.forEach(function(input) {
      input.addEventListener('click', handleInputClick);
    });
  });