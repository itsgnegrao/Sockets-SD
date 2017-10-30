import urllib.request

opener = urllib.request.FancyURLopener({})
url = "http://www.apagina.pt/"
f = opener.open(url)
content = f.read()
print(f)
