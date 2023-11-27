/**
 * 
 */


// Obtener todos los botones con la clase 'btn'
const buttons = document.querySelectorAll('.btn');

// Agregar un evento 'mouseover' a cada botón
buttons.forEach(button => {
  button.addEventListener('mouseover', event => {
    // Cambiar el color de fondo del botón
    event.target.style.backgroundColor = 'blue';
  });
  
  // Agregar un evento 'mouseout' a cada botón
  button.addEventListener('mouseout', event => {
    // Cambiar el color de fondo del botón de nuevo al color original
    event.target.style.backgroundColor = '';
  });
});
