SHELL = /bin/sh

init:
	npm install
	node_modules/.bin/bower install
	rm -rf src/main/webapp/third_party/jquery/src

init-eclipse:
	gradle clean cleanEclipse eclipse

war: 
	gradle war

check:
	gradle check #cobertura coberturaCheck

run:
	gradle jettyRun

stop:
	gradle jettyStop
	
clean:
	gradle clean
	rm -rf node_modules src/main/webapp/third_party build bin

