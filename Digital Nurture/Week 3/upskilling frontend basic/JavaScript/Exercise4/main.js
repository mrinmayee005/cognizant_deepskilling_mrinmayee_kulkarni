let events = [
    { name: "Summer Music Festival", category: "music" },
    { name: "Community Garden Day", category: "outdoor" },
    { name: "Tech Meetup", category: "tech" },
    { name: "Art in the Park", category: "art" }
];

function addEvent(name, category) {
    const n = name || document.getElementById("newEventName").value;
    const c = category || document.getElementById("newEventCategory").value;
    if (n && c) {
        events.push({ name: n, category: c });
        renderAllEvents();
        document.getElementById("newEventName").value = "";
        document.getElementById("newEventCategory").value = "";
    }
}

function renderAllEvents() {
    const list = document.getElementById("allEvents");
    list.innerHTML = "";
    events.forEach(function (event) {
        const li = document.createElement("li");
        li.textContent = `${event.name} (${event.category})`;
        list.appendChild(li);
    });
}

function filterEventsByCategory(category) {
    return events.filter(function (event) {
        return event.category.toLowerCase() === category.toLowerCase();
    });
}

function applyFilter() {
    const category = document.getElementById("filterCategory").value;
    const filtered = filterEventsByCategory(category);
    const result = document.getElementById("filterResult");
    if (filtered.length === 0) {
        result.textContent = `No events found in category "${category}".`;
    } else {
        result.innerHTML = `<strong>Filtered events:</strong><br>` + filtered.map(function (e) { return e.name; }).join(", ");
    }
}

function createRegistrationCounter() {
    let count = 0;
    return function () {
        count++;
        return count;
    };
}

const getRegistrationCount = createRegistrationCounter();

function registerUser() {
    const name = document.getElementById("userName").value;
    if (!name) return;
    const total = getRegistrationCount();
    document.getElementById("regCount").textContent = total;
    document.getElementById("userName").value = "";
    console.log(`Registered: ${name} (Total: ${total})`);
}

function processEvents(events, callback) {
    return events.map(callback);
}

const displayCards = processEvents(events, function (event) {
    return `${event.name} [${event.category}]`;
});

console.log("Display cards:", displayCards);

renderAllEvents();
