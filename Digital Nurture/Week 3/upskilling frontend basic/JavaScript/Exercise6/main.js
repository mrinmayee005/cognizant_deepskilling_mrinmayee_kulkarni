let events = [
    { name: "Summer Music Festival", category: "music", date: "2026-08-15", seats: 50 },
    { name: "Community Garden Day", category: "outdoor", date: "2026-07-20", seats: 30 },
    { name: "Tech Meetup", category: "tech", date: "2026-09-10", seats: 25 },
    { name: "Jazz Night", category: "music", date: "2026-08-30", seats: 40 },
    { name: "Art Workshop", category: "art", date: "2026-09-05", seats: 20 }
];

function renderAllCards() {
    const container = document.getElementById("allCards");
    container.innerHTML = "";
    events.forEach(function (event) {
        const card = document.createElement("div");
        card.className = "card";
        card.innerHTML = `<h3>${event.name}</h3><p>${event.category}</p><p>${event.date}</p>`;
        container.appendChild(card);
    });
}

function addNewEvent() {
    const name = document.getElementById("newEventName").value;
    const category = document.getElementById("newEventCat").value;
    if (name && category) {
        events.push({ name: name, category: category, date: "2026-10-01", seats: 30 });
        renderAllCards();
        renderDisplayCards();
        document.getElementById("newEventName").value = "";
        document.getElementById("newEventCat").value = "";
    }
}

function filterMusic() {
    const musicEvents = events.filter(function (event) {
        return event.category === "music";
    });
    const container = document.getElementById("musicFilter");
    container.innerHTML = musicEvents.map(function (e) {
        return `<strong>${e.name}</strong> - ${e.date}`;
    }).join("<br>") || "No music events found.";
}

function renderDisplayCards() {
    const container = document.getElementById("displayCards");
    container.innerHTML = "";
    const cards = events.map(function (event) {
        return { title: event.name, subtitle: `${event.category} | ${event.date}` };
    });
    cards.forEach(function (card) {
        const div = document.createElement("div");
        div.className = "card";
        div.innerHTML = `<h3>${card.title}</h3><p>${card.subtitle}</p>`;
        container.appendChild(div);
    });
}

renderAllCards();
renderDisplayCards();
