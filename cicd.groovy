node('linux')
{
   
  stage ('Poll') {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/ZOSOpenTools/neovimport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/neovimport.git'), string(name: 'PORT_DESCRIPTION', value: 'Neovim is a Vim-based text editor engineered for extensibility and usability, to encourage new applications and contributions.[D[C[D[C' )]
  }
}
