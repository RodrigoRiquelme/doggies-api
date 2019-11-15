PREFIX_DIR="../"
DIR="doggies-config-server/"
if [ ! -d "${PREFIX_DIR}${DIR}" ]; then
  cd $PREFIX_DIR
  echo "git clone https://github.com/RodrigoRiquelme/doggies-config-server.git in $PWD"
  git clone https://github.com/RodrigoRiquelme/doggies-config-server.git
  cd $DIR
else
  cd "${PREFIX_DIR}${DIR}"
fi
echo "./gradlew build bootRun in $PWD"
./gradlew build bootRun
cd -
