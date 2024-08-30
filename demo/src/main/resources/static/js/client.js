function mostrarMascota() {
  var select = document.getElementById("mascotaSelect");
  var mascotaId = select.value;

  // Ocultar todas las secciones de mascotas
  var secciones = document.querySelectorAll(".datosMascotaSection");
  secciones.forEach(function (section) {
    section.style.display = "none";
  });

  // Mostrar la sección seleccionada
  if (mascotaId) {
    document.getElementById("mascota-" + mascotaId).style.display = "block";
  }
}

// Mostrar la primera mascota por defecto
window.onload = function () {
  document.getElementById("mascotaSelect").selectedIndex = 0; // Selecciona la primera opción
  mostrarMascota(); // Llama a la función para mostrar la primera mascota
};
