// Default Parameters
function createEvent(name, date = "TBA", category = "general", seats = 30) {
    return { name, date, category, seats };
}

const event1 = createEvent("Summer Music Festival", "2026-08-15", "music", 50);
const event2 = createEvent("Pop-up Market");
const event3 = createEvent("Book Fair", "2026-09-01");

document.getElementById("defaultResult").innerHTML = [
    `Event 1: ${event1.name} (${event1.date}, ${event1.category}, ${event1.seats} seats)`,
    `Event 2: ${event2.name} (${event2.date}, ${event2.category}, ${event2.seats} seats)`,
    `Event 3: ${event3.name} (${event3.date}, ${event3.category}, ${event3.seats} seats)`
].join("<br>");

// Destructuring
const event = {
    name: "Tech Meetup",
    date: "2026-09-10",
    category: "tech",
    seats: 25,
    location: "Community Center",
    price: "Free"
};

const { name, date, category, ...otherDetails } = event;

document.getElementById("destructResult").innerHTML = [
    `name: ${name}`,
    `date: ${date}`,
    `category: ${category}`,
    `otherDetails: ${JSON.stringify(otherDetails)}`
].join("<br>");

// Spread Operator for cloning
const originalEvent = { name: "Art Workshop", category: "art", date: "2026-08-25", seats: 20 };
const clonedEvent = { ...originalEvent, seats: 100, location: "City Park" };

document.getElementById("spreadResult").innerHTML = [
    `Original: ${JSON.stringify(originalEvent)}`,
    `Cloned (modified): ${JSON.stringify(clonedEvent)}`,
    `Are they same object? ${originalEvent === clonedEvent}`
].join("<br>");

// Template Literals & Arrow Functions
const formatEvent = (e) => `${e.name} on ${e.date} [${e.category}] - ${e.seats} seats`;
const eventList = [event1, event2, event3, originalEvent];

document.getElementById("templateResult").innerHTML = `<strong>Formatted Events:</strong><br>` +
    eventList.map(formatEvent).join("<br>");

// For...of
console.log("Events (for...of):");
for (const e of eventList) {
    console.log(`  ${e.name}`);
}
