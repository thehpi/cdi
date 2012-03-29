for i in cdi-base-test cdi-interceptor-new-test cdi-interceptor-old-test cdi-test cdi-test-ear
do
	(cd $i ; mvn clean install)
done
