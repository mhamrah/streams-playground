if(!!window.EventSource) {
  var source = new EventSource('/messages');
  var el = document.querySelector('#sse');

  source.addEventListener('published', function(e) {
    console.log('published: ' + e.data);
    var p = document.createElement('p');
    p.textContent = e.data;
    el.appendChild(p);
  }, false);

  source.addEventListener('open', function(e) {
    console.log('opened sse connection.');
  }, false);

  source.addEventListener('error', function(e) {
    console.log('sse error: ' + e);
  }, false);
} else {
  alert('sorry, you don\'t have SSE support!');
}
