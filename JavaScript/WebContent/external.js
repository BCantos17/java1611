/**
 * External source code
 * Reusable
 */
// hello function
function virus(){
	//alert('Hello virus!');
	document.getElementById('message').innerHTML 
		= '<h1>Dan Pickles</h1>';
}

// register event listener with a DOM element
document.getElementById("clickBait")
	.addEventListener("click", virus, false); 