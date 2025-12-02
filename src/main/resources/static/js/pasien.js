const pasienDropdown = document.getElementById("pasienDropdown");
const nextBtn = document.getElementById("nextBtn");

nextBtn.addEventListener("click", () => {
    const pasienId = pasienDropdown.value;

    if (!pasienId) {
        alert("Pilih pasien terlebih dahulu!");
        return;
    }

    fetch("/obat/form");


});