document.addEventListener("DOMContentLoaded", function () {
    const pasienDropdown = document.getElementById("pasienDropdown");
    const obatDropdown   = document.getElementById("obatDropdown");
    const pasienInfoText = document.getElementById("pasienInfoText");
    const detailObatCard = document.getElementById("detail-obat");
    const idPasienField      = document.getElementById("id_pasien_field");
    const idObatField        = document.getElementById("id_obat_field");
    const idAppointmentField = document.getElementById("id_appointment_field");
    const nextBtn    = document.getElementById("nextButton");
    const form       = document.getElementById("transaksiForm");
    const stepPasien = document.getElementById("stepPasien");
    const stepObat   = document.getElementById("stepObat");

    function updateNextButtonState() {
        const ready = idPasienField.value && idObatField.value;
        nextBtn.disabled = !ready;
    }

    pasienDropdown.addEventListener("change", function () {
        const value = this.value;
        const opt   = this.options[this.selectedIndex];

        if (!value) {
            pasienInfoText.textContent = "Belum ada pasien yang dipilih";
            idPasienField.value = "";
            stepPasien.classList.remove("step-completed");
        } else {
            pasienInfoText.textContent = opt.text;
            idPasienField.value = value;
            stepPasien.classList.add("step-completed");
            stepPasien.classList.add("step-active");
        }

        updateNextButtonState();
    });

    obatDropdown.addEventListener("change", function () {
        const value = this.value;
        const opt   = this.options[this.selectedIndex];

        if (!value) {
            detailObatCard.innerHTML = `
                <h3 class="card-title">Detail Obat</h3>
                <p class="card-text">Pilih obat untuk melihat detail</p>
            `;
            idObatField.value = "";
            stepObat.classList.remove("step-completed", "step-active");
        } else {
            const nama      = opt.dataset.nama;
            const pemakaian = opt.dataset.pemakaian;
            const harga     = opt.dataset.harga;

            detailObatCard.innerHTML = `
                <h3 class="card-title">Detail Obat</h3>
                <p class="card-text"><strong>${nama}</strong></p>
                <p class="card-text">${pemakaian}</p>
                <p class="card-text">Harga: Rp ${harga}</p>
            `;

            idObatField.value = value;
            stepObat.classList.add("step-active", "step-completed");
        }

        updateNextButtonState();
    });

    nextBtn.addEventListener("click", function (e) {
        e.preventDefault();

        if (!idPasienField.value || !idObatField.value) {
            alert("Pilih pasien dan obat terlebih dahulu.");
            return;
        }

        form.submit();
    });

    updateNextButtonState();
});
