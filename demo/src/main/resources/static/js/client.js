function mostrarMascota() {
  // Selecciona el primer elemento con la clase 'mascota-select'
  var select = document.querySelector(".mascota-select");
  var mascotaId = select.value;

  // Ocultar todas las secciones de mascotas
  var secciones = document.querySelectorAll(".datosMascotaSection");
  secciones.forEach(function (section) {
    section.style.display = "none";
  });


  // Mostrar la sección seleccionada
  var sectionToShow = document.getElementById("mascota-" + mascotaId);
  
  if (sectionToShow) {
    sectionToShow.style.display = "flex";
  }
}

// Mostrar la primera mascota por defecto al cargar la página
window.onload = function () {
  var select = document.querySelector(".mascota-select");
  select.selectedIndex = 0; 
  mostrarMascota(); // Llama a la función para mostrar la primera mascota
};