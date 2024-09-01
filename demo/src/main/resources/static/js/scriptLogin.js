document.addEventListener('DOMContentLoaded', function() {
    const typeSelect = document.getElementById('type');
    const fields = document.querySelectorAll('.dynamic-fields');

    function updateFields() {
        const selectedValue = typeSelect.value;

        // Hide all dynamic fields
        fields.forEach(field => field.style.display = 'none');

        // Show the selected fields
        switch (selectedValue) {
            case '1': // Veterinario
                document.getElementById('veterinarioFields').style.display = 'block';
                break;
            case '2': // Administrador
                document.getElementById('administradorFields').style.display = 'block';
                break;
            case '3': // Cliente
                document.getElementById('clienteFields').style.display = 'block';
                break;
        }
    }

    // Initialize the form on page load
    updateFields();

    // Update the form when the type changes
    typeSelect.addEventListener('change', updateFields);
});
