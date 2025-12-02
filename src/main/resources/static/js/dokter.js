const contentPanel = document.getElementById("content-panel");
const btnPasien = document.getElementById("btnPasien");
const btnObat   = document.getElementById("btnObat");
const btnDokter = document.getElementById("btnDokter");

const initialTemplate = document.getElementById("content-initial").innerHTML;
const pasienTemplate  = document.getElementById("content-pasien").innerHTML;
const obatTemplate    = document.getElementById("content-obat").innerHTML;
const dokterTemplate  = document.getElementById("content-dokter").innerHTML;

let activeKey = "initial";

function setActiveButton(button) {
    [btnPasien, btnObat, btnDokter].forEach(b => b.classList.remove("active"));
    if (button) {
        button.classList.add("active");
    }
}

function getTemplateByKey(key) {
    switch (key) {
        case "pasien": return pasienTemplate;
        case "obat":   return obatTemplate;
        case "dokter": return dokterTemplate;
        default:       return initialTemplate;
    }
}

function showContent(key, permanent = false) {
    const html = getTemplateByKey(key);
    contentPanel.classList.add("is-fading");

    setTimeout(() => {
        contentPanel.innerHTML = html;
        contentPanel.classList.remove("is-fading");
    }, 180);

    if (permanent) {
        activeKey = key;
    }
}

showContent("initial", true);
setActiveButton(null);

btnPasien.addEventListener("click", () => {
    showContent("pasien", true);
    setActiveButton(btnPasien);
});

btnObat.addEventListener("click", () => {
    showContent("obat", true);
    setActiveButton(btnObat);
});

btnDokter.addEventListener("click", () => {
    showContent("dokter", true);
    setActiveButton(btnDokter);
});

btnPasien.addEventListener("mouseenter", () => showContent("pasien", false));
btnObat.addEventListener("mouseenter", () => showContent("obat", false));
btnDokter.addEventListener("mouseenter", () => showContent("dokter", false));

[btnPasien, btnObat, btnDokter].forEach(btn => {
    btn.addEventListener("mouseleave", () => {
        showContent(activeKey, false);
    });
});
