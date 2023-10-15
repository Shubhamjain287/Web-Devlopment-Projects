let result = "";

function appendToResult(value) {
  result += value;
  document.getElementById("result").value = result;
}

function clearResult() {
  result = "";
  document.getElementById("result").value = result;
}

function calculateResult() {
  try {
    result = eval(result);
    document.getElementById("result").value = result;
  } catch (e) {
    result = "Error";
    document.getElementById("result").value = result;
  }
}
