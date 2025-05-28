
document.getElementById('form-curiosidad').addEventListener('submit', function(e) {
  e.preventDefault();

  var nombre = document.getElementById('nombre').value.trim();
  var curiosidad = document.getElementById('curiosidad').value.trim();

  if (nombre && curiosidad) {
    var comentario = document.createElement('div');
    comentario.className = 'comentario';

    var nombreElemento = document.createElement('strong');
    nombreElemento.textContent = nombre;

    var curiosidadElemento = document.createElement('p');
    curiosidadElemento.textContent = curiosidad;

    comentario.appendChild(nombreElemento);
    comentario.appendChild(curiosidadElemento);

    document.getElementById('comentarios').appendChild(comentario);

    // Limpiar formulario
    document.getElementById('form-curiosidad').reset();
  }
});

