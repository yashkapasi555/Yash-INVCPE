set filedate=%DATE:~4%
set filetime=%TIME:~1,-3%
set filename=Billing_Application_%filedate:/=-%_%filetime::=%.log

mkdir installationdir

ant -quiet -f build-version-install.xml -Dfile.path=%cd% -Dfile.name=%1 -Dinstallation.dir=%cd%\installationdir
