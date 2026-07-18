// Debug Console Logger
function logToConsole(message, type) {
    type = type || "info";
    const output = document.getElementById("consoleOutput");
    const entry = document.createElement("div");
    entry.className = `log-entry ${type}`;
    const timestamp = new Date().toLocaleTimeString();
    entry.textContent = `[${timestamp}] [${type.toUpperCase()}] ${message}`;
    output.appendChild(entry);
    output.scrollTop = output.scrollHeight;
    console.log(`[${type.toUpperCase()}] ${message}`);
}

function clearConsole() {
    document.getElementById("consoleOutput").innerHTML = "";
    logToConsole("Console cleared.");
}

// Step-by-step form submission logging
document.getElementById("debugForm").addEventListener("submit", function (e) {
    e.preventDefault();
    logToConsole("Step 1: Form submission triggered", "step");

    // debugger; // Uncomment to set a breakpoint here

    const name = document.getElementById("dName").value.trim();
    const email = document.getElementById("dEmail").value.trim();
    const event = document.getElementById("dEvent").value;

    logToConsole(`Step 2: Captured form data - Name: "${name}", Email: "${email}", Event: "${event}"`, "step");

    // Validation
    logToConsole("Step 3: Starting validation...", "step");

    if (!name) {
        logToConsole("Validation failed: Name is empty", "error");
        return;
    }
    logToConsole("  ✓ Name validation passed", "info");

    if (!email || !email.includes("@")) {
        logToConsole("Validation failed: Invalid email", "error");
        return;
    }
    logToConsole("  ✓ Email validation passed", "info");

    if (!event) {
        logToConsole("Validation failed: No event selected", "error");
        return;
    }
    logToConsole("  ✓ Event selection validation passed", "info");

    logToConsole("Step 4: All validations passed", "step");

    // Simulate processing
    logToConsole("Step 5: Simulating server request...", "step");
    console.time("ServerRequest");

    setTimeout(function () {
        console.timeEnd("ServerRequest");
        logToConsole("Step 6: Server responded (simulated 1s delay)", "step");

        // Simulate random success/failure
        const success = Math.random() > 0.3;
        if (success) {
            logToConsole(`Step 7: Registration confirmed for ${name}!`, "info");
            console.log("Registration object:", { name: name, email: email, event: event, timestamp: new Date().toISOString() });
            document.getElementById("debugForm").reset();
        } else {
            logToConsole("Step 7: Server returned an error (simulated)", "error");
            logToConsole("  Retry logic would go here...", "warn");
        }
    }, 1000);
});

// Console testing functions
function runBasicTests() {
    logToConsole("Running basic tests...", "step");

    // Test 1: String operations
    const eventName = "Summer Music Festival";
    console.assert(eventName.length > 0, "Event name should not be empty");
    console.assert(eventName.includes("Music"), "Event name should contain 'Music'");
    logToConsole("  ✓ Test 1: String operations passed", "info");

    // Test 2: Array operations
    const events = ["music", "outdoor", "tech", "art"];
    console.assert(events.length === 4, "Should have 4 events");
    const musicEvents = events.filter(function (e) { return e === "music"; });
    console.assert(musicEvents.length === 1, "Should find 1 music event");
    logToConsole("  ✓ Test 2: Array operations passed", "info");

    // Test 3: Object operations
    const event = { name: "Test Event", seats: 10 };
    event.seats--;
    console.assert(event.seats === 9, "Seat should decrement");
    logToConsole("  ✓ Test 3: Object operations passed", "info");

    // Test 4: Function return values
    function add(a, b) { return a + b; }
    console.assert(add(2, 3) === 5, "2 + 3 should equal 5");
    logToConsole("  ✓ Test 4: Function tests passed", "info");

    logToConsole("All tests passed!", "info");
    console.table([
        { test: "String operations", status: "PASS" },
        { test: "Array operations", status: "PASS" },
        { test: "Object operations", status: "PASS" },
        { test: "Function return values", status: "PASS" }
    ]);
}

// Auto-run tests on load
logToConsole("Page loaded. Ready for debugging.", "info");
logToConsole("Tip: Type runBasicTests() in console to run test suite.", "warn");
