#!/bin/sh
#REM Default locations of jars we depend on
#echo "These agents have been deprecated. Please visit New Agents section of JISP Billing to execute all agents."

#cd ${BILLING_HOME}/billutils/agentrun
#
#JAR_HOME=${JBOSS_HOME}/client
#
#unset TMP_CLASSPATH
#for i in ${JAR_HOME}/*.jar ; do
#  if [ "$TMP_CLASSPATH" != "" ]; then
#    TMP_CLASSPATH=${TMP_CLASSPATH}:$i
#  else
#    TMP_CLASSPATH=$i
#  fi
#done
#
#JAR_HOME=${JBOSS_HOME}/lib
#
#for i in ${JAR_HOME}/*.jar ; do
#  if [ "$TMP_CLASSPATH" != "" ]; then
#    TMP_CLASSPATH=${TMP_CLASSPATH}:$i
#  else
#    TMP_CLASSPATH=$i
#  fi
#done
#unzip -o -qq ${BILLING_HOME}/ear/billing.ear
#
#JAR_HOME=.
#
#for i in ${JAR_HOME}/*.jar ; do
#  if [ "$TMP_CLASSPATH" != "" ]; then
#    TMP_CLASSPATH=${TMP_CLASSPATH}:$i
#  else
#    TMP_CLASSPATH=$i
#  fi
#done
#
#for i in ${BILLING_HOME}/wars/operations-manager/WEB-INF/lib/*.jar ; do
#  if [ "$TMP_CLASSPATH" != "" ]; then
#    TMP_CLASSPATH=${TMP_CLASSPATH}:$i
#  else
#    TMP_CLASSPATH=$i
#  fi
#done

#echo $TMP_CLASSPATH

echo `date` " Sla Agent Started" >> slainterface.log

$ANT_HOME/bin/ant -f agent-slainterface.xml -Darg.value="$*" >> slainterface.log
echo `date` " Sla Agent Stopped" >> slainterface.log

