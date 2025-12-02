window.addEventListener("DOMContentLoaded", function () {
    const formDrA = document.getElementById("formDrA");
    const formDrB = document.getElementById("formDrB");
    const formDrC = document.getElementById("formDrC");

    const kotakA = document.querySelector(".kotak1");
    const kotakB = document.querySelector(".kotak2");
    const kotakC = document.querySelector(".kotak3");

    const backdrop = document.getElementById("modalBackdrop");

    function hideAllForms() {
        if (formDrA) formDrA.classList.add("hidden");
        if (formDrB) formDrB.classList.add("hidden");
        if (formDrC) formDrC.classList.add("hidden");
        if (backdrop) backdrop.classList.add("hidden");
    }

    function showForm(formEl) {
        hideAllForms();
        if (formEl) formEl.classList.remove("hidden");
        if (backdrop) backdrop.classList.remove("hidden");
    }

    if (kotakA) {
        kotakA.addEventListener("click", function () {
            showForm(formDrA);
        });
    }

    if (kotakB) {
        kotakB.addEventListener("click", function () {
            showForm(formDrB);
        });
    }

    if (kotakC) {
        kotakC.addEventListener("click", function () {
            showForm(formDrC);
        });
    }

    if (backdrop) {
        backdrop.addEventListener("click", hideAllForms);
    }

    document.addEventListener("keydown", function (e) {
        if (e.key === "Escape") {
            hideAllForms();
        }
    });
});
